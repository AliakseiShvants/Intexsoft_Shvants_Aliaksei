package com.shvants.UrlShorter.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Simple JB object that represents role of {@link User}
 */

public enum Role{
    ADMIN,
    USER,
    GUEST
}
