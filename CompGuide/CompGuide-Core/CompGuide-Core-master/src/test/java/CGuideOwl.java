import cguide.execution.entities.ClinicalTask;
import cguide.execution.entities.Question;
import cguide.parser.GuidelineHandler;
import org.semanticweb.owlapi.io.OWLObjectRenderer;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import uk.ac.manchester.cs.owlapi.dlsyntax.DLSyntaxObjectRenderer;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: tiago
 * Date: 19-08-2013
 * Time: 20:34
 * To change this template use File | Settings | File Templates.
 */
public class CGuideOwl {
    private static final String BASE_URL = "http://www.semanticweb.org/ontologies/2012/3/CompGuide.owl";
    private static OWLObjectRenderer renderer = new DLSyntaxObjectRenderer();
    public static void main(String[] args) throws OWLOntologyCreationException {
        Boolean load;
        GuidelineHandler parser = new GuidelineHandler();
        System.out.println("Loading action...");
        load = parser.loadGuideline();
        ArrayList<String> tasks = new ArrayList<String>();
        if(load){
            ClinicalTask task = parser.getClinicalTask("Question2");
            Question question  = (Question) task;
            System.out.println(question.toJson());
        }
        else{
            System.out.println("failed to load Check the filename");

        }



        /*//prepare ontology and reasoner
        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
        //OWLOntology ontology = manager.loadOntologyFromOntologyDocument(IRI.create(BASE_URL));
        OWLOntology ontology = manager.loadOntologyFromOntologyDocument(IRI.create("file:///c://Cguide.owl"));
        OWLReasonerFactory reasonerFactory = PelletReasonerFactory.getInstance();
        OWLReasoner reasoner = reasonerFactory.createReasoner(ontology, new SimpleConfiguration());
        OWLDataFactory factory = manager.getOWLDataFactory();
        PrefixOWLOntologyFormat pm = (PrefixOWLOntologyFormat) manager.getOntologyFormat(ontology);
        pm.setDefaultPrefix(BASE_URL + "#");

        //get class and its individuals
        OWLClass personClass = factory.getOWLClass(":Entities.action", pm);
        OWLNamedIndividual individual = factory.getOWLNamedIndividual(":CPG", pm);
        Map<OWLDataPropertyExpression, Set<OWLLiteral>> dataPropertyValues = individual.getDataPropertyValues(manager.getOntology(IRI.create(BASE_URL)));
        Map<OWLObjectPropertyExpression, Set<OWLIndividual>> objectPropertyValues = individual.getObjectPropertyValues(manager.getOntology(IRI.create(BASE_URL)));
        Entities.action action = new Entities.action();
        for (Map.Entry<OWLDataPropertyExpression, Set<OWLLiteral>> entry : dataPropertyValues.entrySet()) {

            String field = parseIRI(entry.getKey().toString());
            Set<OWLLiteral> s =  entry.getValue();
            for(OWLLiteral literal : s){
                if(field.equals("dateOfLastUpdate")){action.setDateofupdate(parseDateTime(literal.getLiteral()));}
                if(field.equals("dateOfCreation")){action.setDateofcreation(parseDateTime(literal.getLiteral()));}
                if(field.equals("versionNumber")){action.setVersionnumber(literal.getLiteral());}
                if(field.equals("actionName")){action.setactionname(literal.getLiteral());}
                if(field.equals("authorship")){action.setAuthorship(literal.getLiteral());}
                if(field.equals("actionDescription")){action.setactiondescription(literal.getLiteral());}
            }

        }
        for (Map.Entry<OWLObjectPropertyExpression, Set<OWLIndividual>> entry : objectPropertyValues.entrySet()) {

            System.out.println(entry);
            String field = parseIRI(entry.getKey().toString());
            Set<OWLIndividual> s =  entry.getValue();
            for(OWLIndividual literal : s){
                //System.out.println(literal);
            }

        }


        System.out.println(action.getAuthorship());
        System.out.println(action.getDateofcreation());
        System.out.println(action.getDateofupdate());
        System.out.println(action.getactiondescription());
        System.out.println(action.getactionname());
        System.out.println(action.getVersionnumber());
*/
        // reasoner.getDataPropertyValues(individual,dataProperty);

        /*//get a given individual
        OWLNamedIndividual martin = factory.getOWLNamedIndividual(":CPG", pmMartin
        //get values of selected properties on the individual
        OWLDataProperty hasEmailProperty = factory.getOWLDataProperty(":hasnet",hasEmail
        OWLObjectProperty isEmployedAtProperty = factory.getOWLObjectProperty(":isEmployedAt", pm);
", pm);
s email: + email.getLiteral());
        }*/
/*
        for (OWLNamedIndividual ind : reasoner.getObjectPropertyValues(martin, isEmployedAtProperty).getFlattened()) {
           y/*em.out.println("Martin is employed at: " + renderer.render(ind));
        }

        //get labels
        LocalizedAnnotationSelector as = new LocalizedAnnotationSelector(ontology, factory, "en", "cs");
        for (OWLNamedIndividual ind : reasoner.getObjectPropertyValues(martin, isEmployedAtProperty).getFlattened()) {
            System.out.println("Martin is employed at: '" + as.getLabel(ind) + "'");
        }

        //get inverse of a property, i.e. which individuals are in relation with a given individual
        OWLNamedIndividual university = factory.getOWLNamedIndividual(":MU", pm);
        OWLObjectPropertyExpression inverse = factory.getOWLObjectInverseOf(isEmployedAtProperty);
        for (OWLNamedIndividual ind : reasoner.getObjectPropertyValues(university, inverse).getFlattened()) {
            System.out.println("MU inverseOf(isEmployedAt) -> " + renderer.render(ind));
        }

        //find to which classes the individual belongs
        Set<OWLClassExpression> assertedClasses = martin.getTypes(ontology);
        for (OWLClass c : reasoner.getTypes(martin, false).getFlattened()) {
            boolean asserted = assertedClasses.contains(c);
            System.out.println((asserted ? "asserted" : "inferred") + " class for Martin: " + renderer.render(c));
        }

        //list all object property values for the individual
        Map<OWLObjectPropertyExpression, Set<OWLIndividual>> assertedValues = martin.getObjectPropertyValues(ontology);
        for (OWLObjectProperty objProp : ontology.getObjectPropertiesInSignature(true)) {
            for (OWLNamedIndividual ind : reasoner.getObjectPropertyValues(martin, objProp).getFlattened()) {
                boolean asserted = assertedValues.get(objProp).contains(ind);
                System.out.println((asserted ? "asserted" : "inferred") + " object property for Martin: "
                        + renderer.render(objProp) + " -> " + renderer.render(ind));
            }
        }

        //list all same individuals
        for (OWLNamedIndividual ind : reasoner.getSameIndividuals(martin)) {
            System.out.println("same as Martin: " + renderer.render(ind));
        }

        //ask reasoner whether Martin is employed at MU
        boolean result = reasoner.isEntailed(factory.getOWLObjectPropertyAssertionAxiom(isEmployedAtProperty, martin, university));
        System.out.println("Is Martin employed at MU ? : " + result);


        //check whether the SWRL rule is used
        OWLNamedIndividual ivan = factory.getOWLNamedIndividual(":Ivan", pm);
        OWLClass chOMPClass = factory.getOWLClass(":ChildOfMarriedParents", pm);
        OWLClassAssertionAxiom axiomToExplain = factory.getOWLClassAssertionAxiom(chOMPClass, ivan);
        System.out.println("Is Ivan child of married parents ? : " + reasoner.isEntailed(axiomToExplain));


        //explain why Ivan is child of married parents
        DefaultExactionationGenerator exactionationGenerator =
                new DefaultExactionationGenerator(
                        manager, reasonerFactory, ontology, reasoner, new SilentExactionationProgressMonitor());
        Set<OWLAxiom> exactionation = exactionationGenerator.getExactionation(axiomToExplain);
        ExactionationOrderer deo = new ExactionationOrdererImpl(manager);
        ExactionationTree exactionationTree = deo.getOrderedExactionation(axiomToExplain, exactionation);
        System.out.println();
        System.out.println("-- exactionation why Ivan is in class ChildOfMarriedParents --");
        printIndented(exactionationTree, "");*/
    }



    public static String parseIRI(String iri){
        Pattern pattern = Pattern.compile("#(.*?)>");
        Matcher matcher = pattern.matcher(iri);
        if (matcher.find()) {
            return (matcher.group(1));
        }
        return null;
    }
    public static String parseDateTime(String datetime){
        return datetime.replaceAll("T", " ");
    }
}
