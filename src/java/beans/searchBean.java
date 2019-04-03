/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;
import EJB.TylerEJB;
import entity.Citation;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
/**
 *
 * @author zxd170230
 */
@Named(value = "searchBean")
@SessionScoped
public class searchBean implements Serializable{
    @EJB
    private TylerEJB TylerEJB;
    private String businessName;

    public searchBean(){
    }
    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }
    
    public List<Citation> getCaseList()
    {
       List<Citation> allCase = TylerEJB.findAllCases();
       List<Citation> temp=new ArrayList<>();
        for(int i= 0;i<allCase.size();i++)
        {
            if(allCase.get(i).getBusinessName().equals(businessName)){
            temp.add(allCase.get(i));
            }
        }
        return temp;
        //return allTheater;
    }
}
