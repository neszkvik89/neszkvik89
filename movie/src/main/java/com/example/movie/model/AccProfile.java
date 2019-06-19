package com.example.movie.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AccProfile {

  @Id
  private String jti;
  private Date iat;
  private String sub;
  private String iss;
  private Date exp;

  public AccProfile(String jti, Date iat, String sub, String iss, Date exp) {
    this.jti = jti;
    this.iat = iat;
    this.sub = sub;
    this.iss = iss;
    this.exp = exp;
  }

  public AccProfile() {
  }

  public String getJti() {
    return jti;
  }

  public void setJti(String jti) {
    this.jti = jti;
  }

  public Date getIat() {
    return iat;
  }

  public void setIat(Date iat) {
    this.iat = iat;
  }

  public String getSub() {
    return sub;
  }

  public void setSub(String sub) {
    this.sub = sub;
  }

  public String getIss() {
    return iss;
  }

  public void setIss(String iss) {
    this.iss = iss;
  }

  public Date getExp() {
    return exp;
  }

  public void setExp(Date exp) {
    this.exp = exp;
  }
}
