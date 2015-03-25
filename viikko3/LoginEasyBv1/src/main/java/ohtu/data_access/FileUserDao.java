package ohtu.data_access;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
//import ohtu.ConstructorInjection;
import ohtu.domain.User;
//import org.springframework.beans.factory.BeanFactory;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FileUserDao implements UserDao {
    private String path;
    
    public FileUserDao() {
//        BeanFactory beanfactory = new ClassPathXmlApplicationContext("spring-context.xml");
//        ConstructorInjection bean = (ConstructorInjection) beanfactory.getBean("springMessage");

        this.path = "src/userDB.txt";
    }
    
    @Override
    public List<User> listAll() {
        Scanner scanner = scanner();
        if (scanner == null) {
            return null;
        }
        
        ArrayList<User> users = new ArrayList<User>();
        
        while (scanner.hasNextLine()) {
            String username = scanner.nextLine();
            String password = scanner.nextLine();
            users.add(new User(username, password));
        }
        return users;
    }

    @Override
    public User findByName(String name) {
        List<User> users = listAll();
        
        for (User user : users) {
            if (user.getUsername().equals(name)) {
                return user;
            }
        }

        return null;
    }

    @Override
    public void add(User user) {
        FileWriter writer = writer();
        
        if (writer == null) {
            throw new IllegalStateException("path invalid");
        }
        
        try {
            writer.append(user.getUsername() + "\n" + user.getPassword() + "\n");
        }
        catch (IOException e) {
            throw new IllegalStateException("writing was not possible for some reason");
        }
        
        
    }
    
    private FileWriter writer() {
        try {
            return new FileWriter(new File(path)); 
        }
        
        catch (IOException ex) {
            Logger.getLogger(FileUserDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    private Scanner scanner() {
        try {
            return new Scanner(new File(path)); 
        }
        
        catch (FileNotFoundException ex) {
            Logger.getLogger(FileUserDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
//
//    <bean id="springMessage" class="ohtu.ConstructorInjection">
//        <constructor-arg type="java.lang.String" value="src/userDB.txt" />
//    </bean>
//    
//    <bean id="fileUserDao" class="ohtu.data_access.FileUserDao" scope="prototype">
//        <constructor-arg ref="springMessage" />
//    </bean>