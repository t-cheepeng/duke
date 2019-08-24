package com.chee.commands;

/**
 * Represents a action that Duke can take; a command to Duke.
 * <p>
 *     This interface dictates what all commands are able to do.
 *     Follows SAM and it can be used as a functional interface
 *     to make annonymous commands as required. The interface
 *     only holds one method that when called upon will execute
 *     the action that implementing classes dictate it to do.
 *     All required resources to perform said action is to be
 *     obtained through the constructor of implementing classes.
 *     This interface will make no gurantees as to the validity
 *     of the action or the acquiring of other objects to perform
 *     said action.
 * </p>
 */
public interface Command {

    /**
     * Executes the action that the command represents.
     */
    void execute();
}
