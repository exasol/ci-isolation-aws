package com.exasol.ciisonlation.aws;

import software.amazon.awscdk.services.iam.PolicyDocument;

/**
 * This class reads a policy document from a JSON file from the resources.
 * <p>
 * For information on how to generate these files check the README.md.
 * </p>
 */
public class PolicyReader {
    /**
     * Read a policy document from file in the resources.
     * 
     * @param resourceName name of the resource
     * @return read policy document
     */
    public PolicyDocument readPolicyFromResources(final String resourceName) {
        final Object policyJson = new ResourceAsJsonReader().readResourceAsJsonObjects(resourceName);
        return PolicyDocument.fromJson(policyJson);
    }
}
