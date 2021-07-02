package com.exasol.ciisonlation.aws;

import software.amazon.awscdk.core.*;

/**
 * Stack with Tags.
 */
public class TaggedStack extends Stack {
    private final CfnParameter exaOwner;
    private final String projectName;

    /**
     * Create a new instance of {@link TaggedStack}.
     * 
     * @param scope       CDK scope
     * @param id          CDK id
     * @param props       CDK stack properties
     * @param projectName name of the project (used as exa:project tag)
     */
    public TaggedStack(final Construct scope, final String id, final StackProps props, final String projectName) {
        super(scope, id, props);
        this.projectName = projectName;
        this.exaOwner = CfnParameter.Builder.create(this, "exaOwner").type("String")
                .description("Exasol project owner e-mail address.").build();
    }

    /**
     * Get the owner of this stack (configurable via parameter).
     * 
     * @return owner
     */
    protected String getOwner() {
        return this.exaOwner.getValueAsString();
    }

    /**
     * Tag a CDK resource.
     * 
     * @param resource resource to tag
     */
    protected void tagResource(final IConstruct resource) {
        Tags.of(resource).add("exa:project", this.projectName);
        Tags.of(resource).add("exa:owner", getOwner());
    }
}
