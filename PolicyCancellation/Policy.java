package PolicyCancellation;

import java.util.*;
public class Policy
{
    private String policyId;
    private boolean isActive;
    private boolean isCancelable;

    public Policy(String policyId, boolean isActive, boolean isCancelable) {
        this.policyId = policyId;
        this.isActive = isActive;
        this.isCancelable = isCancelable;
    }

    public String getPolicyId() {
        return policyId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isCancelable() {
        return isCancelable;
    }
}

class PolicyCancellation {
    private Map<String, Policy> policies = new HashMap<>();

    public void addPolicy(Policy policy) {
        policies.put(policy.getPolicyId(), policy);
    }

    public void cancelPolicy(String policyId) throws CancellationNotAllowedException, PolicyNotFoundException {
        Policy policy = policies.get(policyId);
        if (policy == null) {
            throw new PolicyNotFoundException("Policy with ID " + policyId + " not found.");
        }
        if (!policy.isCancelable()) {
            throw new CancellationNotAllowedException("Cancellation not allowed for policy ID " + policyId + ".");
        }
        policy.setActive(false);
        log("Policy canceled: " + policyId);
    }

    private void log(String message) {
        System.out.println("Log: " + message);
    }

    public static void main(String[] args) {
        PolicyCancellation pc = new PolicyCancellation();
        Policy policy1 = new Policy("P123", true, true);
        Policy policy2 = new Policy("P124", true, false);

        pc.addPolicy(policy1);
        pc.addPolicy(policy2);

        try {
            pc.cancelPolicy("P123");
            System.out.println("Policy P123 status: " + (policy1.isActive() ? "Active" : "Canceled"));
        } catch (CancellationNotAllowedException | PolicyNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            pc.cancelPolicy("P124");
            System.out.println("Policy P124 status: " + (policy2.isActive() ? "Active" : "Canceled"));
        } catch (CancellationNotAllowedException | PolicyNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            pc.cancelPolicy("P125");
        } catch (CancellationNotAllowedException | PolicyNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}