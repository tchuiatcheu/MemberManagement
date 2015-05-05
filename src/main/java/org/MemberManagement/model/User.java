package org.MemberManagement.model;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;
import java.lang.Override;
import org.MemberManagement.model.Member;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class User implements Serializable
{

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "id", updatable = false, nullable = false)
   private Long id;
   @Version
   @Column(name = "version")
   private int version;

   @OneToOne
   private Member username;

   @Column
   private String password;

   @Column
   private String profile;

   @Column
   private boolean isActif;

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
      if (!(obj instanceof User))
      {
         return false;
      }
      User other = (User) obj;
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

   public Member getUsername()
   {
      return username;
   }

   public void setUsername(Member username)
   {
      this.username = username;
   }

   public String getPassword()
   {
      return password;
   }

   public void setPassword(String password)
   {
      this.password = password;
   }

   public String getProfile()
   {
      return profile;
   }

   public void setProfile(String profile)
   {
      this.profile = profile;
   }

   public boolean isIsActif()
   {
      return isActif;
   }

   public void setIsActif(boolean isActif)
   {
      this.isActif = isActif;
   }

   @Override
   public String toString()
   {
      String result = getClass().getSimpleName() + " ";
      if (password != null && !password.trim().isEmpty())
         result += "password: " + password;
      if (profile != null && !profile.trim().isEmpty())
         result += ", profile: " + profile;
      result += ", isActif: " + isActif;
      return result;
   }
}