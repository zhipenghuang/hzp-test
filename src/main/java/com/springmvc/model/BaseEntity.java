package com.springmvc.model;

import java.beans.ConstructorProperties;
import java.util.Date;
import com.springmvc.utils.AbstractEntity;

public class BaseEntity extends AbstractEntity {
 protected Long id;
 protected Date createdAt;
 protected Byte delFlag;
 protected String remarks;
 protected Date updatedAt;

 public BaseEntity() {
     this.createdAt = new Date();
     this.updatedAt = new Date();
     this.delFlag = Byte.valueOf((byte) 0);
     this.remarks = "";
 }

 public Long getId() {
     return this.id;
 }

 public Date getCreatedAt() {
     return this.createdAt;
 }

 public Byte getDelFlag() {
     return this.delFlag;
 }

 public String getRemarks() {
     return this.remarks;
 }

 public Date getUpdatedAt() {
     return this.updatedAt;
 }

 public void setId(Long id) {
     this.id = id;
 }

 public void setCreatedAt(Date createdAt) {
     this.createdAt = createdAt;
 }

 public void setDelFlag(Byte delFlag) {
     this.delFlag = delFlag;
 }

 public void setRemarks(String remarks) {
     this.remarks = remarks;
 }

 public void setUpdatedAt(Date updatedAt) {
     this.updatedAt = updatedAt;
 }

 public boolean equals(Object o) {
     if(o == this) {
         return true;
     } else if(!(o instanceof BaseEntity)) {
         return false;
     } else {
         BaseEntity other = (BaseEntity)o;
         if(!other.canEqual(this)) {
             return false;
         } else {
             label71: {
                 Long this$id = this.getId();
                 Long other$id = other.getId();
                 if(this$id == null) {
                     if(other$id == null) {
                         break label71;
                     }
                 } else if(this$id.equals(other$id)) {
                     break label71;
                 }

                 return false;
             }

             Date this$createdAt = this.getCreatedAt();
             Date other$createdAt = other.getCreatedAt();
             if(this$createdAt == null) {
                 if(other$createdAt != null) {
                     return false;
                 }
             } else if(!this$createdAt.equals(other$createdAt)) {
                 return false;
             }

             label57: {
                 Byte this$delFlag = this.getDelFlag();
                 Byte other$delFlag = other.getDelFlag();
                 if(this$delFlag == null) {
                     if(other$delFlag == null) {
                         break label57;
                     }
                 } else if(this$delFlag.equals(other$delFlag)) {
                     break label57;
                 }

                 return false;
             }

             String this$remarks = this.getRemarks();
             String other$remarks = other.getRemarks();
             if(this$remarks == null) {
                 if(other$remarks != null) {
                     return false;
                 }
             } else if(!this$remarks.equals(other$remarks)) {
                 return false;
             }

             Date this$updatedAt = this.getUpdatedAt();
             Date other$updatedAt = other.getUpdatedAt();
             if(this$updatedAt == null) {
                 if(other$updatedAt == null) {
                     return true;
                 }
             } else if(this$updatedAt.equals(other$updatedAt)) {
                 return true;
             }

             return false;
         }
     }
 }

 protected boolean canEqual(Object other) {
     return other instanceof BaseEntity;
 }

 public int hashCode() {
     boolean PRIME = true;
     byte result = 1;
     Long $id = this.getId();
     int result1 = result * 59 + ($id == null?43:$id.hashCode());
     Date $createdAt = this.getCreatedAt();
     result1 = result1 * 59 + ($createdAt == null?43:$createdAt.hashCode());
     Byte $delFlag = this.getDelFlag();
     result1 = result1 * 59 + ($delFlag == null?43:$delFlag.hashCode());
     String $remarks = this.getRemarks();
     result1 = result1 * 59 + ($remarks == null?43:$remarks.hashCode());
     Date $updatedAt = this.getUpdatedAt();
     result1 = result1 * 59 + ($updatedAt == null?43:$updatedAt.hashCode());
     return result1;
 }

 public String toString() {
     return "BaseEntity(id=" + this.getId() + ", createdAt=" + this.getCreatedAt() + ", delFlag=" + this.getDelFlag() + ", remarks=" + this.getRemarks() + ", updatedAt=" + this.getUpdatedAt() + ")";
 }

 @ConstructorProperties({"id", "createdAt", "delFlag", "remarks", "updatedAt"})
 public BaseEntity(Long id, Date createdAt, Byte delFlag, String remarks, Date updatedAt) {
     this.id = id;
     this.createdAt = createdAt;
     this.delFlag = delFlag;
     this.remarks = remarks;
     this.updatedAt = updatedAt;
 }
}
