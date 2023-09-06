package com.dakr.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "vendor_tble")
@Data
public class Vendor {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
private String vendor_name;
private String vendor_location;
private Integer vendor_price;
private String vendor_desc;
@Lob
private String vendor_image;
}
