package org.MemberManagement.model;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;
import java.lang.Override;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Member implements Serializable
{

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "id", updatable = false, nullable = false)
   private Long id;
   @Version
   @Column(name = "version")
   private int version;

   @Column
   private String firstName;

   @Column
   private String lastName;

   @Column
   private String email;

   @Column
   private int phone;

   @Column
   private String city;

   @Column
   @Temporal(TemporalType.DATE)
   private Date birthDay;

   @Column
   private String occupation;

   @Column
   private Float subscription;

   @OneToOne
   private Member invitedBy;

   @Column(length = 10000)
   private String notes;

   public Long getId()
   {
      return this.id;
   }

   public void setId(final Long id)
   {
      this.id = id;
   }

   public int getVersion()
   {
      return this.version;
   }

   public void setVersion(final int version)
   {
      this.version = version;
   }

   @Override
   public boolean equals(Object obj)
   {
      if (this == obj)
      {
         return true;
      }
      if (!(obj instanceof Member))
      {
         return false;
      }
      Member other = (Member) obj;
      if (id != null)
      {
         if (!id.equals(other.id))
         {
            return false;
         }
      }
      return true;
   }

   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((id == null) ? 0 : id.hashCode());
      return result;
   }

   public String getFirstName()
   {
      return firstName;
   }

   public void setFirstName(String firstName)
   {
      this.firstName = firstName;
   }

   public String getLastName()
   {
      return lastName;
   }

   public void setLastName(String lastName)
   {
      this.lastName = lastName;
   }

   public String getEmail()
   {
      return email;
   }

   public void setEmail(String email)
   {
      this.email = email;
   }

   public int getPhone()
   {
      return phone;
   }

   public void setPhone(int phone)
   {
      this.phone = phone;
   }

   public String getCity()
   {
      return city;
   }

   public void setCity(String city)
   {
      this.city = city;
   }

   public Date getBirthDay()
   {
      return birthDay;
   }

   public void setBirthDay(Date birthDay)
   {
      this.birthDay = birthDay;
   }

   public String getOccupation()
   {
      return occupation;
   }

   public void setOccupation(String occupation)
   {
      this.occupation = occupation;
   }

   public Float getSubscription()
   {
      return subscription;
   }

   public void setSubscription(Float subscription)
   {
      this.subscription = subscription;
   }

   public Member getInvitedBy()
   {
      return invitedBy;
   }

   public void setInvitedBy(Member invitedBy)
   {
      this.invitedBy = invitedBy;
   }

   public String getNotes()
   {
      return notes;
   }

   public void setNotes(String notes)
   {
      this.notes = notes;
   }

   @Override
   public String toString()
   {
      String result = getClass().getSimpleName() + " ";
      if (firstName != null && !firstName.trim().isEmpty())
         result += "firstName: " + firstName;
      if (lastName != null && !lastName.trim().isEmpty())
         result += ", lastName: " + lastName;
      if (email != null && !email.trim().isEmpty())
         result += ", email: " + email;
      result += ", phone: " + phone;
      if (city != null && !city.trim().isEmpty())
         result += ", city: " + city;
      if (occupation != null && !occupation.trim().isEmpty())
         result += ", occupation: " + occupation;
      if (subscription != null)
         result += ", subscription: " + subscription;
      if (notes != null && !notes.trim().isEmpty())
         result += ", notes: " + notes;
      return result;
   }
}