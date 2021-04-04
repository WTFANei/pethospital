package cn.anei.pethospital.dto;

import cn.anei.pethospital.entity.Prescription;
import lombok.Data;

import java.util.Date;


@Data
public class PrescriptionDto {

    private String id;
    private String oid;
    private String mid;
    private Integer mnum;
    private Double cprice;
    private Integer status;
    private Date ptime;

    public PrescriptionDto(Prescription prescription) {
        this.id = prescription.getId();
        this.oid = prescription.getOid();
        this.mid = prescription.getMid();
        this.mnum = prescription.getMnum();
        this.cprice = prescription.getCpirce();
        this.status = prescription.getStatus();
        this.ptime = prescription.getPtime();
    }
}
