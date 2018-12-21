package hx.com.modle;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
@Entity   						//表名该类是一个实体类
@Table(name="user")   //建立当前类和数据库表的对应关系
public class User implements Serializable {
	@Id  //表名当前字段时主键
	@Column(name="id") //表名对应数据库的主键字段时cust_id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Integer id ;
	@Column(name="name") 
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
}
