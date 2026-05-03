package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserData {
    VALID_FIRST_NAME("IVAN"),
    VALID_LAST_NAME("IVANOV"),
    VALID_ZIP_CODE("672000"),
    UNVALID_FIRST_NAME(""),
    UNVALID_LAST_NAME(""),
    UNVALID_ZIP_CODE("");

    private final String value;
}
