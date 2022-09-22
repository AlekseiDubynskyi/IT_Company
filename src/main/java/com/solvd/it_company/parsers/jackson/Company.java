package com.solvd.it_company.parsers.jackson;

public class Company {
    private String name;
    private String owner;
    private String field;
    private int employeesQuantity;

    public Company() {
    }

    public Company(String name, String owner, String field, int employeesQuantity) {
        this.name = name;
        this.owner = owner;
        this.field = field;
        this.employeesQuantity = employeesQuantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public int getEmployeesQuantity() {
        return employeesQuantity;
    }

    public void setEmployeesQuantity(int employeesQuantity) {
        this.employeesQuantity = employeesQuantity;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", owner='" + owner + '\'' +
                ", field='" + field + '\'' +
                ", employeesQuantity=" + employeesQuantity +
                '}';
    }
}
