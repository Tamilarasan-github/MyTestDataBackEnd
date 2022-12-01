package backend.applications.applicationOne.testdataInputTables.tableOne;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import backend.applications.applicationOne.TestDataMetaAppOneEntity;


@Component
@Entity
@Table(name="TEST_DATA_APP_TABLE_ONE")
public class TestDataAppOneTableOneEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@SequenceGenerator(name = "TEST_DATA_ID", sequenceName = "TEST_DATA_ID_TABLE_ONE_SEQ", schema="tamil", allocationSize = 1)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TEST_DATA_ID")
	@Column(name="TEST_DATA_ID")
	private Integer testDataId;
		
	@Column(name="TEST_ROW_DETAIL")
	private String testRowDetail;
	
	@Column(name="DELETE_FLAG")
	private String deleteFlag;
	
	@Column(name="COLUMN1")
	private String column1;
	
	@Column(name="COLUMN2")
	private String column2;
	
	@Column(name="COLUMN3")
	private String column3;
	
	@Column(name="COLUMN4")
	private String column4;
	
	@Column(name="COLUMN5")
	private String column5;
	
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "TEST_DATA_APP_META_ID")
	private TestDataMetaAppOneEntity testDataMeta;
	
	public TestDataAppOneTableOneEntity()
	{
		
	}
	
	

	public TestDataAppOneTableOneEntity(Integer testDataId, String testRowDetail, String deleteFlag, String column1, String column2,
			String column3, String column4, String column5, TestDataMetaAppOneEntity testDataMeta)
	{
		super();
		this.testDataId = testDataId;
		this.testRowDetail = testRowDetail;
		this.deleteFlag = deleteFlag;
		this.column1 = column1;
		this.column2 = column2;
		this.column3 = column3;
		this.column4 = column4;
		this.column5 = column5;
		this.testDataMeta = testDataMeta;
	}



	public Integer getTestDataId()
	{
		return testDataId;
	}

	public void setTestDataId(Integer testDataId)
	{
		this.testDataId = testDataId;
	}

	
	public String getTestRowDetail()
	{
		return testRowDetail;
	}

	public void setTestRowDetail(String testRowDetail)
	{
		this.testRowDetail = testRowDetail;
	}

	public String getDeleteFlag()
	{
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag)
	{
		this.deleteFlag = deleteFlag;
	}

	public String getColumn1()
	{
		return column1;
	}

	public void setColumn1(String column1)
	{
		this.column1 = column1;
	}

	public String getColumn2()
	{
		return column2;
	}

	public void setColumn2(String column2)
	{
		this.column2 = column2;
	}

	public String getColumn3()
	{
		return column3;
	}

	public void setColumn3(String column3)
	{
		this.column3 = column3;
	}

	public String getColumn4()
	{
		return column4;
	}

	public void setColumn4(String column4)
	{
		this.column4 = column4;
	}

	public String getColumn5()
	{
		return column5;
	}

	public void setColumn5(String column5)
	{
		this.column5 = column5;
	}

	public TestDataMetaAppOneEntity getTestDataMeta()
	{
		return testDataMeta;
	}

	public void setTestDataMeta(TestDataMetaAppOneEntity testDataMeta)
	{
		this.testDataMeta = testDataMeta;
	}

	@Override
	public String toString()
	{
		return "TestDataAppOneTableOne [testDataId=" + testDataId + ", testRowDetail=" + testRowDetail + ", deleteFlag="
				+ deleteFlag + ", column1=" + column1 + ", column2=" + column2 + ", column3=" + column3 + ", column4="
				+ column4 + ", column5=" + column5 + "]";
	}
	
	
	

}
