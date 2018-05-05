package com.penstash.maram.surveyapp.Models;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

import java.util.Date;

/**
 * Created by maram on 10/03/2018.
 */

@Table
public class Surveys extends SugarRecord {

//Variables
    private long id;

    int SurveyId;

    String Name;

    int IndustryId;
    int CompanyId;
    int DivisionId;
    int BranchId;
    int DepartmentId;

    String CreationDate;
    String StartDate;
    String EndDate;

    boolean Active;

    String CreatedBy;




//Constructor
    public Surveys(){}



//Methods
    public Surveys(int surveyId, String name, int industryId, int companyId, int divisionId, int branchId, int departmentId, String creationDate, String startDate, String endDate, boolean active, String createdBy){

        this.SurveyId = surveyId;

        this.Name = name;

        this.IndustryId = industryId;
        this.CompanyId = companyId;
        this.DivisionId = divisionId;
        this.BranchId = branchId;
        this.DepartmentId = departmentId;

        this.CreationDate = creationDate;
        this.StartDate = startDate;
        this.EndDate = endDate;

        this.Active = active;

        this.CreatedBy = createdBy;
    }



//Return Values
    public int getSurveyId(){
        return SurveyId;
    }

    public String getName(){
        return Name;
    }

    public int getIndustryId(){
        return IndustryId;
    }

    public int getCompanyId(){
        return CompanyId;
    }

    public int getDivisionId(){
        return DivisionId;
    }

    public int getBranchId(){
        return BranchId;
    }

    public int getDepartmentId(){
        return DepartmentId;
    }

    public String getCreationDate(){
        return CreationDate;
    }

    public String getStartDate(){
        return StartDate;
    }

    public String getEndDate(){
        return EndDate;
    }

    public boolean isActive(){
        return Active;
    }

    public String getCreatedBy(){
        return CreatedBy;
    }


}
