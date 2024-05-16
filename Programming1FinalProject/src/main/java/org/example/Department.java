package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Department {
    private String departmentId;
    private String departmentName;
    private static int nextId = 1;

    public Department(String departmentId, String departmentName) {
        if (validateDepartmentName(departmentName)) {
            this.departmentId = departmentId;
            this.departmentName = departmentName;
        } else {
            this.departmentId = null;
            this.departmentName = null;
        }
    }

    /**
     * validates the department name
     * @param departmentName the name of the department being validated
     * @return true if the department name is valid
     */
    public boolean validateDepartmentName(String departmentName) {
        for (int i = 0; i < departmentName.length(); i++) {
            char c = departmentName.charAt(i);

            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }
}
