package cn.anei.pethospital.repository;

import cn.anei.pethospital.entity.CountData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface CountRepository extends JpaRepository<CountData, String>{

    @Query(value = "SELECT A.ITEM_ID AS ID, COUNT(A.ITEM_ID) AS COUNT, B.ITEM_NAME AS NAME FROM ORDERINFO A INNER JOIN ITEM B ON A.ITEM_ID = B.ITEM_ID WHERE (A.USER_ID = ?1 AND A.FINISH_TIME BETWEEN ?2 AND ?3 AND A.IS_FINISH = 1 AND A.STATUS = 0) GROUP BY A.ITEM_ID, B.ITEM_NAME" ,nativeQuery = true)
    List<CountData> getCountItemForUser(String userId, Date startDate, Date endDate);

    @Query(value = "SELECT A.MEDICINE_ID AS ID, SUM(A.MEDICINE_NUM) AS COUNT, B.MEDICINE_NAME AS NAME FROM PRESCRIPTION A INNER JOIN MEDICINE B ON A.MEDICINE_ID = B.MEDICINE_ID WHERE (A.ORDER_ID IN(SELECT C.ORDER_ID FROM ORDERINFO C WHERE C.USER_ID = ?1) AND A.PRESCRIPTION_TIME BETWEEN ?2 AND ?3 AND A.STATUS = 0) GROUP BY A.MEDICINE_ID, B.MEDICINE_NAME" ,nativeQuery = true)
    List<CountData> getCountMedicineForUser(String userId, Date startDate, Date endDate);

    @Query(value = "SELECT A.ITEM_ID AS ID, COUNT(A.ITEM_ID) AS COUNT, B.ITEM_NAME AS NAME FROM ORDERINFO A INNER JOIN ITEM B ON A.ITEM_ID = B.ITEM_ID WHERE (A.FINISH_TIME BETWEEN ?1 AND ?2 AND A.IS_FINISH = 1 AND A.STATUS = 0) GROUP BY A.ITEM_ID, B.ITEM_NAME" ,nativeQuery = true)
    List<CountData> getCountItemForAdmin(Date startDate, Date endDate);

    @Query(value = "SELECT A.MEDICINE_ID AS ID, SUM(A.COUNT_PRICE) AS COUNT, B.MEDICINE_NAME AS NAME FROM PRESCRIPTION A INNER JOIN MEDICINE B ON A.MEDICINE_ID = B.MEDICINE_ID WHERE (A.PRESCRIPTION_TIME BETWEEN ?1 AND ?2 AND A.STATUS = 0) GROUP BY A.MEDICINE_ID, B.MEDICINE_NAME" ,nativeQuery = true)
    List<CountData> getCountMedicineForAdmin(Date startDate, Date endDate);
}
