package backend.applications.applicationOne.testdataInputTables.tableTwo;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import backend.applications.applicationOne.TestDataMetaAppOneTableEntity;


@Component
@Entity
@Table(name="TEST_DATA_APP_TABLE_TWO")
public class TestDataAppOneTableTwoTableEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="TEST_DATA_ID")
	private int testDataId;
		
	@Column(name="TEST_ROW_DETAIL")
	private String testRowDetail;
	
	@Column(name="DELETE_FLAG")
	private String deleteFlag;
	
	@Column(name="COLUMN_A")
	private String column1;
	
	@Column(name="COLUMN_B")
	private String columnB;
	
	@Column(name="COLUMN_C")
	private String columnC;
	
	@Column(name="COLUMN_D")
	private String columnD;
	
	@Column(name="COLUMN_E")
	private String columnE;
	
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "TEST_DATA_META_ID")
	private TestDataMetaAppOneTableEntity testDataMeta;
	
	protected TestDataAppOneTableTwoTableEntity()
	{
		
	}

	public TestDataAppOneTableTwoTableEntity(int testDataId, String testRowDetail, String deleteFlag, String column1, String columnB,
			String columnC, String columnD, String columnE, TestDataMetaAppOneTableEntity testDataMeta)
	{
		super();
		this.testDataId = testDataId;
		this.testRowDetail = testRowDetail;
		this.deleteFlag = deleteFlag;
		this.column1 = column1;
		this.columnB = columnB;
		this.columnC = columnC;
		this.columnD = columnD;
		this.columnE = columnE;
		this.testDataMeta = testDataMeta;
	}

	public int getTestDataId()
	{
		return testDataId;
	}

	public void setTestDataId(int testDataId)
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

	public String getColumnB()
	{
		return columnB;
	}

	public void setColumnB(String columnB)
	{
		this.columnB = columnB;
	}

	public String getColumnC()
	{
		return columnC;
	}

	public void setColumnC(String columnC)
	{
		this.columnC = columnC;
	}

	public String getColumnD()
	{
		return columnD;
	}

	public void setColumnD(String columnD)
	{
		this.columnD = columnD;
	}

	public String getColumnE()
	{
		return columnE;
	}

	public void setColumnE(String columnE)
	{
		this.columnE = columnE;
	}

	public TestDataMetaAppOneTableEntity getTestDataMeta()
	{
		return testDataMeta;
	}

	public void setTestDataMeta(TestDataMetaAppOneTableEntity testDataMeta)
	{
		this.testDataMeta = testDataMeta;
	}

	@Override
	public String toString()
	{
		return "TestDataAppTableTwo [testDataId=" + testDataId + ", testRowDetail=" + testRowDetail + ", deleteFlag="
				+ deleteFlag + ", column1=" + column1 + ", columnB=" + columnB + ", columnC=" + columnC + ", columnD="
				+ columnD + ", columnE=" + columnE + "]";
	}
	
}
