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
@Entity   						//����������һ��ʵ����
@Table(name="user")   //������ǰ������ݿ��Ķ�Ӧ��ϵ
public class User implements Serializable {
	@Id  //������ǰ�ֶ�ʱ����
	@Column(name="id") //������Ӧ���ݿ�������ֶ�ʱcust_id
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
