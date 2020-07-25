package docfriends.assignment.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EncryptionType {
    SHA_256("SHA-256");

    private final String type;

}
