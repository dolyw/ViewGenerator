package com.uframe.generator.util;

import java.util.*;
import java.io.*;

public class GeneratorException extends RuntimeException
{
    public List<Exception> exceptions;
    
    public GeneratorException() {
        this.exceptions = new ArrayList<Exception>();
    }
    
    public GeneratorException(final String message, final Throwable cause) {
        super(message, cause);
        this.exceptions = new ArrayList<Exception>();
    }
    
    public GeneratorException(final String message) {
        super(message);
        this.exceptions = new ArrayList<Exception>();
    }
    
    public GeneratorException(final Throwable cause) {
        super(cause);
        this.exceptions = new ArrayList<Exception>();
    }
    
    public List<Exception> getExceptions() {
        return this.exceptions;
    }
    
    public void setExceptions(final List<Exception> exceptions) {
        if (exceptions == null) {
            throw new NullPointerException("'exceptions' must be not null");
        }
        this.exceptions = exceptions;
    }
    
    public GeneratorException add(final Exception e) {
        this.exceptions.add(e);
        return this;
    }
    
    public GeneratorException addAll(final List<Exception> excetpions) {
        this.exceptions.addAll(excetpions);
        return this;
    }
    
    @Override
    public void printStackTrace() {
        this.printStackTrace(System.err);
    }
    
    @Override
    public void printStackTrace(final PrintStream s) {
        s.println("GeneratorException:" + this.getMessage());
        for (final Exception e : this.exceptions) {
            e.printStackTrace(s);
        }
    }
    
    @Override
    public void printStackTrace(final PrintWriter s) {
        s.println("GeneratorException:" + this.getMessage());
        for (final Exception e : this.exceptions) {
            e.printStackTrace(s);
        }
    }
    
    @Override
    public String toString() {
        final StringWriter out = new StringWriter();
        for (final Exception e : this.exceptions) {
            out.append(String.valueOf(e.toString()) + "\n");
        }
        return out.toString();
    }
}
