package com.BackendTask.IdentityReconciliation.JDBCAccess;

import com.BackendTask.IdentityReconciliation.Dao.contactDAO;
import com.BackendTask.IdentityReconciliation.Data.contact;
import com.BackendTask.IdentityReconciliation.Data.contactData;
import com.BackendTask.IdentityReconciliation.Data.inputData;
import com.BackendTask.IdentityReconciliation.Data.outputData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.*;

@Repository("jdbc")
public class contactJDBC implements contactDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public contactJDBC(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    String pattern = "YYYY-MM-DD hh:mm:ss";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    String date = simpleDateFormat.format(new Date());

    private int generateRandomId1() {
        return new Random().nextInt(1000);
    }
    @Override
    public outputData identify(inputData inputData){

        int randId = generateRandomId1();

        var sqlForGet= """
                 select *
                 from contact_data
                 where email=? or phone_number=?;
                 """;

        RowMapper<contactData> contactDataRowMapper=(rs, rowNumber)->{
            contactData contactDataValue=new contactData(
                    rs.getInt("id"),
                    rs.getString("email"),
                    rs.getString("phone_number"),
                    rs.getDate("created_at")
            );
            return contactDataValue;
        };
        List<contactData> c1=jdbcTemplate.query(sqlForGet,contactDataRowMapper,inputData.getEmail(),inputData.getPhoneNumber());

        if (c1.isEmpty()){
            var sql= """
                Insert into contact_data(id,phone_number,email,linked_id,linked_precedence,created_at,updated_at,deleted_at)
                values (?,?,?,?,?,?,?,?)
                """;
            int result= jdbcTemplate.update(sql,randId,inputData.getPhoneNumber(),inputData.getEmail(),null,"primary",new Date(),new Date(),null);
            System.out.println(result+"/rows affected");
        }
        int num=0;
        contact c=new contact();
        for (contactData b:c1){
            if(Objects.equals(inputData.getEmail(),b.getEmail()) && !Objects.equals(inputData.getPhoneNumber(), b.getPhoneNumber())){
                int id=b.getId();
                num=id;
                c.setPrimaryContactId(randId);
                c.setEmails(new String[]{inputData.getEmail()});
                c.setPhoneNumbers(new String[]{inputData.getPhoneNumber(),b.getPhoneNumber()});
                c.setSecondaryContactIds(id);
                var sql= """
                Insert into contact_data(id,phone_number,email,linked_id,linked_precedence,created_at,updated_at,deleted_at)
                values (?,?,?,?,?,?,?,?)
                """;
                int result= jdbcTemplate.update(sql,randId,inputData.getPhoneNumber(),inputData.getEmail(),id,"secondary",b.getCreatedAt(),new Date(),null);
                System.out.println(Arrays.toString(new String[]{inputData.getPhoneNumber(), b.getPhoneNumber()}));
            }
            else if (!Objects.equals(inputData.getEmail(),b.getEmail()) && Objects.equals(inputData.getPhoneNumber(), b.getPhoneNumber())){
                int id=b.getId();
                num=id;
                // Output Values
                c.setPrimaryContactId(randId);
                c.setEmails(new String[]{inputData.getEmail(),b.getEmail()});
                c.setPhoneNumbers(new String[]{inputData.getPhoneNumber()});
                c.setSecondaryContactIds(id);

                // Inserting into DB
                var sql= """
                Insert into contact_data(id,phone_number,email,linked_id,linked_precedence,created_at,updated_at,deleted_at)
                values (?,?,?,?,?,?,?,?)
                """;
                int result= jdbcTemplate.update(sql,randId,inputData.getPhoneNumber(),inputData.getEmail(),id,"secondary",b.getCreatedAt(),new Date(),null);
                System.out.println(Arrays.toString(new String[]{inputData.getEmail(), b.getEmail()}));
            } else {
                System.out.println("Nothing1");
                break;
            }
            outputData outputData=new outputData(c);
            return outputData;
        }
        return null;
    }
}
