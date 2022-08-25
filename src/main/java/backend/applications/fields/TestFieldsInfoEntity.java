package backend.applications.fields;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="TEST_FIELDS_INFO")
public class TestFieldsInfoEntity
{
	@Id
	private long field_id;
	private String field_name;
	private String field_name_api;
	private String field_name_db;
	private String ui_screen_name;
	private String field_data_type;
	private long table_id;
	private int field_order;
	private String delete_flag;
	private String created_by;
	private Date created_on;
	private String updated_by;
	private Date updated_on;
	
	public TestFieldsInfoEntity()
	{
		
	}

	public TestFieldsInfoEntity(long field_id, String field_name, String field_name_api, String field_name_db,
			String ui_screen_name, String field_data_type, long table_id, int field_order, String delete_flag, String created_by,
			Date created_on, String updated_by, Date updated_on)
	{
		super();
		this.field_id = field_id;
		this.field_name = field_name;
		this.field_name_api = field_name_api;
		this.field_name_db = field_name_db;
		this.ui_screen_name=ui_screen_name;
		this.field_data_type = field_data_type;
		this.table_id = table_id;
		this.field_order = field_order;
		this.delete_flag = delete_flag;
		this.created_by = created_by;
		this.created_on = created_on;
		this.updated_by = updated_by;
		this.updated_on = updated_on;
	}

	public long getField_id()
	{
		return field_id;
	}

	public void setField_id(long field_id)
	{
		this.field_id = field_id;
	}

	public String getField_name()
	{
		return field_name;
	}

	public void setField_name(String field_name)
	{
		this.field_name = field_name;
	}

	public String getField_name_api()
	{
		return field_name_api;
	}

	public void setField_name_api(String field_name_api)
	{
		this.field_name_api = field_name_api;
	}

	public String getField_name_db()
	{
		return field_name_db;
	}

	public void setField_name_db(String field_name_db)
	{
		this.field_name_db = field_name_db;
	}
	
	public String getUi_screen_name()
	{
		return ui_screen_name;
	}

	public void setUi_screen_name(String ui_screen_name)
	{
		this.ui_screen_name = ui_screen_name;
	}
	
	public String getField_data_type()
	{
		return field_data_type;
	}

	public void setField_data_type(String field_data_type)
	{
		this.field_data_type = field_data_type;
	}

	public long getTable_id()
	{
		return table_id;
	}

	public void setTable_id(long table_id)
	{
		this.table_id = table_id;
	}

	public int getField_order()
	{
		return field_order;
	}

	public void setField_order(int field_order)
	{
		this.field_order = field_order;
	}

	public String getDelete_flag()
	{
		return delete_flag;
	}

	public void setDelete_flag(String delete_flag)
	{
		this.delete_flag = delete_flag;
	}

	public String getCreated_by()
	{
		return created_by;
	}

	public void setCreated_by(String created_by)
	{
		this.created_by = created_by;
	}

	public Date getCreated_on()
	{
		return created_on;
	}

	public void setCreated_on(Date created_on)
	{
		this.created_on = created_on;
	}

	public String getUpdated_by()
	{
		return updated_by;
	}

	public void setUpdated_by(String updated_by)
	{
		this.updated_by = updated_by;
	}

	public Date getUpdated_on()
	{
		return updated_on;
	}

	public void setUpdated_on(Date updated_on)
	{
		this.updated_on = updated_on;
	}

	@Override
	public String toString()
	{
		return "TestFieldsInfoEntity [field_id=" + field_id + ", field_name=" + field_name + ", field_name_api="
				+ field_name_api + ", field_name_db=" + field_name_db + ", ui_screen_name=" + ui_screen_name
				+ ", field_data_type=" + field_data_type + ", table_id=" + table_id + ", field_order=" + field_order
				+ ", delete_flag=" + delete_flag + ", created_by=" + created_by + ", created_on=" + created_on
				+ ", updated_by=" + updated_by + ", updated_on=" + updated_on + "]";
	}

		

}
