package bean;

import javax.persistence.*;
import java.util.Objects;

/**
 * Copyright © 2018 Chris. All rights reserved.
 *
 * @author Chris
 * 2018/4/17 10:34
 * @see bean
 */
@Entity
@Table(name = "friendship", schema = "chatroom", catalog = "")
public class FriendshipEntity {
    private int id;
    private Long intimate;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "intimate")
    public Long getIntimate() {
        return intimate;
    }

    public void setIntimate(Long intimate) {
        this.intimate = intimate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FriendshipEntity that = (FriendshipEntity) o;
        return id == that.id &&
                Objects.equals(intimate, that.intimate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, intimate);
    }
}
