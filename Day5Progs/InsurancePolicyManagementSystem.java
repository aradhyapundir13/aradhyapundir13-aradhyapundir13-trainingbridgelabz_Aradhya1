package Day5Progs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Policy{
    String policyNumber;
    String policyHolderName;
    Date expiryDate;
    String coverageType;
    double premiumAmount;

    public Policy(String policyNumber, String policyHolderName, Date expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public int compareTo(Policy other) {
        return this.policyNumber.compareTo(other.policyNumber);
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getPolicyHolderName() {
        return policyHolderName;
    }

    public void setPolicyHolderName(String policyHolderName) {
        this.policyHolderName = policyHolderName;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    public void setCoverageType(String coverageType) {
        this.coverageType = coverageType;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    public void setPremiumAmount(double premiumAmount) {
        this.premiumAmount = premiumAmount;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "policyNumber='" + policyNumber + '\'' +
                ", policyHolderName='" + policyHolderName + '\'' +
                ", expiryDate=" + expiryDate +
                ", coverageType='" + coverageType + '\'' +
                ", premiumAmount=" + premiumAmount +
                '}';
    }
}

public class InsurancePolicyManagementSystem {
    HashSet<Policy> hashPolicy;
    LinkedHashSet<Policy> linkPolicy;
    TreeSet<Policy> treePolicy;
    public InsurancePolicyManagementSystem(){
        hashPolicy=new HashSet<>();
        linkPolicy=new LinkedHashSet<>();
        treePolicy=new TreeSet<>();
    }
    static Policy takePolicy() throws ParseException {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter your policy no : ");
        String pn=sc.nextLine();

        System.out.print("Name : ");
        String name=sc.nextLine();

        System.out.print("Date (29/04/2023) : ");
        String date= sc.next();

        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        Date dt=sdf.parse(date);
        sdf.setLenient(false);
        try {
            Date parsedDate = sdf.parse(date);
            System.out.println("Parsed date: " + parsedDate);
        } catch (ParseException e) {
            System.out.println("Unparseable date: " + e.getMessage());
        }
        sc.nextLine();
        System.out.print("Coverage Type : ");
        String coverageType=sc.nextLine();

        System.out.print("Premium : ");
        int premium=sc.nextInt();

        Policy p1=new Policy(pn,name,dt,coverageType,premium);
        return p1;
    }
    public Policy addPolicy() throws ParseException {
        Policy p1=takePolicy();
        hashPolicy.add(p1);
        linkPolicy.add(p1);
        treePolicy.add(p1);
        return p1;
    }
    public Set<Policy> getAllUniquePolicies(){
        return new LinkedHashSet<>(linkPolicy);
    }
    public Set<Policy> findDuplicatePolicies(Policy policy){
        Set<Policy> ans=new TreeSet<>();
        for(Policy p:linkPolicy){
            if(p.compareTo(policy)==0){
                ans.add(p);
            }
        }
        return ans;
    }
    public Set<Policy> getPolicyExpiringSoon(int days){
        Set<Policy> result=new TreeSet<>();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH,days);
        Date expiryDate = calendar.getTime();
        for(Policy p:treePolicy){
            if(p.getExpiryDate().before(expiryDate)){
                result.add(p);
            }
        }
        return result;
    }
    public Set<Policy> getPolicyByCoverage(String coverage){
        Set<Policy> ans=new HashSet<>();
        for (Policy p: hashPolicy){
            if(p.getCoverageType().equals(coverage)){
                ans.add(p);
            }
        }
        return  ans;
    }
    public void printPolicies(Set<Policy> policy){
        for(Policy p:policy){
            System.out.println("Policy No : "+p.getPolicyNumber());
            System.out.println("Date of Policy : "+p.getExpiryDate());
            System.out.println("Policy Holder : "+p.getPolicyHolderName());
            System.out.println("Coverage : "+p.getCoverageType());
            System.out.println("Premium : "+p.getPremiumAmount());
        }
    }

    public static void main(String[] args) throws ParseException {
        InsurancePolicyManagementSystem m1=new InsurancePolicyManagementSystem();
        System.out.println("Policy 1");
        Policy testPolicy=m1.addPolicy();
        System.out.println("Policy 2");
        m1.addPolicy();
        System.out.println("Policy 3");
        m1.addPolicy();
        System.out.println("Printing all unique Policies : ");
        Set<Policy> unique=m1.getAllUniquePolicies();
        m1.printPolicies(unique);
        System.out.println("Printing Policies Expiring soon (30 Days) : ");
        Set<Policy> expiring=m1.getPolicyExpiringSoon(30);
        m1.printPolicies(expiring);
        System.out.println("Policies of coverage type health - ");
        Set<Policy> p=m1.getPolicyByCoverage("health");
        m1.printPolicies(p);
        System.out.println("Duplicate policies : ");
        Set<Policy> duplicate=m1.findDuplicatePolicies(testPolicy);
        m1.printPolicies(duplicate);

    }

}