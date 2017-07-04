package cguide.db.beans;

import org.apache.commons.lang.builder.*;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: tiago
 * Date: 31-07-2013
 * Time: 13:19
 * To change this template use File | Settings | File Templates.
 */
public class NonmedicationBean implements Serializable {
    private Long idnonmedication;
    private String name;
    private String description;
    private Long idtask;
    private String time;
    private String identifier;

    public Long getIdtask() {
        return idtask;
    }

    public void setIdtask(Long idtask) {
        this.idtask = idtask;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public Long getIdnonmedication() {
        return idnonmedication;
    }

    public void setIdnonmedication(Long idnonmedication) {
        this.idnonmedication = idnonmedication;
    }

    //UTILS
    public void copy(NonmedicationBean bean)
    {
        setTime(bean.getTime());
        setIdnonmedication(bean.getIdnonmedication());
        setIdtask(bean.getIdtask());
        setDescription(bean.getDescription());
        setName(bean.getName());
        setIdentifier(bean.getIdentifier());
    }
    public boolean equals(Object object)
    {
        if (!(object instanceof NonmedicationBean)) {
            return false;
        }

        NonmedicationBean obj = (NonmedicationBean) object;
        return new EqualsBuilder()
                .append(getIdtask(), obj.getIdtask())
                .append(getTime(), obj.getTime())
                .append(getDescription(),obj.getDescription())
                .append(getName(),obj.getName())
                .append(getIdnonmedication(), obj.getIdnonmedication())
                .append(getIdentifier(),obj.getIdnonmedication())
                .isEquals();
    }

    public int hashCode()
    {
        return new HashCodeBuilder(-82280557, -700257973)
                .append(getIdtask())
                .append(getTime())
                .append(getDescription())
                .append(getName())
                .append(getIdnonmedication())
                .append(getIdentifier())
                .toHashCode();
    }

    public String toString()
    {
        return toString(ToStringStyle.MULTI_LINE_STYLE);
    }

    /**
     * you can use the following styles:
     * <li>ToStringStyle.DEFAULT_STYLE</li>
     * <li>ToStringStyle.MULTI_LINE_STYLE</li>
     * <li>ToStringStyle.NO_FIELD_NAMES_STYLE</li>
     * <li>ToStringStyle.SHORT_PREFIX_STYLE</li>
     * <li>ToStringStyle.SIMPLE_STYLE</li>
     */
    public String toString(ToStringStyle style) {
        return new ToStringBuilder(this, style)
                .append("idtask", getIdtask())
                .append("time",getTime())
                .append("description", getDescription())
                .append("name", getName())
                .append("idnonmedication", getIdnonmedication())
                .append("identifier",getIdentifier())
                .toString();
    }
    public int compareTo(Object object)
    {
        NonmedicationBean obj = (NonmedicationBean) object;
        return new CompareToBuilder()
                .append(getIdtask(), obj.getIdtask())
                .append(getTime(),obj.getTime())
                .append(getDescription(), obj.getDescription())
                .append(getName(), obj.getName())
                .append(getIdnonmedication(), obj.getIdnonmedication())
                .append(getIdentifier(),obj.getIdentifier())
                .toComparison();
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}
