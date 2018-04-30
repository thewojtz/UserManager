package com.wlegwand.entity;

import com.wlegwand.entity.User;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="usergroup")
public class UserGroup {

    @Id
    @Column(name = "idusergroup")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idusergroup;
    @Column(name = "usergroupname")
    private String userGroupName;



    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "usergroup")
    private List<User> userlist = new ArrayList<User>();

        public int size() {
            return 0;
        }

        public boolean isEmpty() {
            return false;
        }

        public boolean contains(Object o) {
            return false;
        }

        public Iterator<User> iterator() {
            return null;
        }

        public Object[] toArray() {
            return new Object[0];
        }

        public <T> T[] toArray(T[] a) {
            return null;
        }

        public boolean add(User user) {
            return false;
        }

        public boolean remove(Object o) {
            return false;
        }

        public boolean containsAll(Collection<?> c) {
            return false;
        }

        public boolean addAll(Collection<? extends User> c) {
            return false;
        }

        public boolean addAll(int index, Collection<? extends User> c) {
            return false;
        }

        public boolean removeAll(Collection<?> c) {
            return false;
        }

        public boolean retainAll(Collection<?> c) {
            return false;
        }

        public void clear() {

        }

        public User get(int index) {
            return null;
        }

        public User set(int index, User element) {
            return null;
        }

        public void add(int index, User element) {

        }

        public User remove(int index) {
            return null;
        }

        public int indexOf(Object o) {
            return 0;
        }

        public int lastIndexOf(Object o) {
            return 0;
        }

        public ListIterator<User> listIterator() {
            return null;
        }

        public ListIterator<User> listIterator(int index) {
            return null;
        }

        public List<User> subList(int fromIndex, int toIndex) {
            return null;
        }


    public UserGroup() {
    }
    public UserGroup(String userGroupName) {
        this.userGroupName = userGroupName;
    }
    public UserGroup(String userGroupName, List<User> userList) {
        this.userGroupName = userGroupName;
        this.userlist = userList;
    }

    public Integer getId() {
        return idusergroup;
    }

    public void setId(Integer id) {
        this.idusergroup = id;
    }

    public String getUserGroupName() {
        return userGroupName;
    }

    public void setUserGroupName(String userGroupName) {
        this.userGroupName = userGroupName;
    }

    public List<User> getUserList() {
        return userlist;
    }

    public void setUserList(List<User> userList) {
        this.userlist = userList;
    }
}
