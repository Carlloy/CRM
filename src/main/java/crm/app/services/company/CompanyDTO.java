package crm.app.services.company;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyDTO {

    private String name;
    private String createdby;


    public CompanyDTO(String name, String createdby) {
        this.name = name;
        this.createdby = createdby;
    }

    public CompanyDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatedby() {

        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }
}