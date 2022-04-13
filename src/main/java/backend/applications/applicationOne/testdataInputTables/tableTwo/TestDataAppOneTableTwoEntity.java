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

import backend.applications.applicationOne.TestDataMetaAppOneEntity;


@Component
@Entity
@Table(name="TEST_DATA_APP_TABLE_TWO")
public class TestDataAppOneTableTwoEntity
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
	private String columnA;
	
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
	private TestDataMetaAppOneEntity testDataMeta;
	
	protected TestDataAppOneTableTwoEntity()
	{
		
	}

	public TestDataAppOneTableTwoEntity(int testDataId, String testRowDetail, String deleteFlag, String columnA, String columnB,
			String columnC, String columnD, String columnE, TestDataMetaAppOneEntity testDataMeta)
	{
		super();
		this.testDataId = testDataId;
		this.testRowDetail = testRowDetail;
		this.deleteFlag = deleteFlag;
		this.columnA = columnA;
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

	public String getColumnA()
	{
		return columnA;
	}

	public void setColumnA(String columnA)
	{
		this.columnA = columnA;
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
		return "TestDataAppTableTwo [testDataId=" + testDataId + ", testRowDetail=" + testRowDetail + ", deleteFlag="
				+ deleteFlag + ", columnA=" + columnA + ", columnB=" + columnB + ", columnC=" + columnC + ", columnD="
				+ columnD + ", columnE=" + columnE + "]";
	}
	
}
