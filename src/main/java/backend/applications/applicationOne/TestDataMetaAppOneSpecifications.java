package backend.applications.applicationOne;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import backend.applications.SearchCriteria;
import backend.applications.SearchCriteria.SearchOperator;
import backend.applications.applicationOne.testdataInputTables.tableOne.TestDataAppOneTableOneTableEntity;
import net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler.ForAbstractMethod;

public class TestDataMetaAppOneSpecifications implements Specification<TestDataMetaAppOneTableEntity>
{

	private static final long serialVersionUID = 1L;
	public List<SearchCriteria> searchCriteriaList;
	
	public TestDataMetaAppOneSpecifications()
	{
		searchCriteriaList=new ArrayList<SearchCriteria>();
	}
	
	public void addNewSearchCriteria(SearchCriteria newSearchCriteria)
	{
		searchCriteriaList.add(newSearchCriteria);
	}
	
	@Override
	public Predicate toPredicate(Root<TestDataMetaAppOneTableEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder)
	{
		List<Predicate> predicatesList = new ArrayList<Predicate>();
		
		for (SearchCriteria searchCriteria : searchCriteriaList)
		{
			String[] fieldValues=searchCriteria.getStringList();
			long[] fieldNumberValues=searchCriteria.getNumberList();
			long number=searchCriteria.getNumber();
			
			if(number!=0)
			{
				conditionsNumber(predicatesList, searchCriteria, number, root, query, criteriaBuilder);
			}
			else if(fieldValues!=null && fieldValues.length>0)
			{
				List<String> fieldValuesList=Arrays.asList(fieldValues);
				for (String fieldValue : fieldValuesList)
				{
					conditions(predicatesList, searchCriteria, fieldValue, root, query, criteriaBuilder);
				}
				
			}
			else if(fieldNumberValues!=null && fieldNumberValues.length>0)
			{
				for(int i=0;i<=fieldNumberValues.length;i++)
				{
					conditionsNumber(predicatesList, searchCriteria, fieldNumberValues[0], root, query, criteriaBuilder);
				}
			}
			else if(searchCriteria.getDateFrom()!=null && searchCriteria.getDateTo()!=null)
			{
				SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
				
				if(searchCriteria.getOperator().equals(SearchOperator.BETWEEN_DATES))
				{			
				}
			}
		}
		return criteriaBuilder.and(predicatesList.toArray(new Predicate[0]));
	}
	
	
		
		
		
	
	
	public void conditions(List<Predicate> predicatesList,SearchCriteria searchCriteria, String fieldValue, Root<TestDataMetaAppOneTableEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder)
	{
		if(searchCriteria.getOperator().equals(SearchOperator.IN))
		{
			predicatesList.add(criteriaBuilder.in(root.get(searchCriteria.getKey())).value(fieldValue));
		}
		else if(searchCriteria.getOperator().equals(SearchOperator.NOT_IN))
		{
			predicatesList.add(criteriaBuilder.not(root.get(searchCriteria.getKey())).in(fieldValue));
		}
		else if(searchCriteria.getOperator().equals(SearchOperator.GREATER_THAN))
		{
			//predicatesList.add(criteriaBuilder.gt(root.get(searchCriteria.getKey())).value(fieldValuesList));
		}
		else if(searchCriteria.getOperator().equals(SearchOperator.LESSER_THAN))
		{
			//predicatesList.add(criteriaBuilder.in(root.get(searchCriteria.getKey())).value(fieldValuesList));
		}
		else if(searchCriteria.getOperator().equals(SearchOperator.GREATER_THAN_EQUAL))
		{
			//predicatesList.add(criteriaBuilder.in(root.get(searchCriteria.getKey())).value(fieldValuesList));
		}
		else if(searchCriteria.getOperator().equals(SearchOperator.LESSER_THAN_EQUAL))
		{
			//predicatesList.add(criteriaBuilder.in(root.get(searchCriteria.getKey())).value(fieldValuesList));
		}
		else if(searchCriteria.getOperator().equals(SearchOperator.EQUALS_TO))
		{
			//predicatesList.add(criteriaBuilder.in(root.get(searchCriteria.getKey())).value(fieldValuesList));
		}
		else if(searchCriteria.getOperator().equals(SearchOperator.NOT_EQUAL))
		{
			//predicatesList.add(criteriaBuilder.in(root.get(searchCriteria.getKey())).value(fieldValuesList));
		}
		else if(searchCriteria.getOperator().equals(SearchOperator.CONTAINS))
		{
			//predicatesList.add(criteriaBuilder.in(root.get(searchCriteria.getKey())).value(fieldValuesList));
		}
		else if(searchCriteria.getOperator().equals(SearchOperator.STARTS_WITH))
		{
			//predicatesList.add(criteriaBuilder.in(root.get(searchCriteria.getKey())).value(fieldValuesList));
		}
	}
	
	public void conditionsNumber(List<Predicate> predicatesList,SearchCriteria searchCriteria, long fieldValue, Root<TestDataMetaAppOneTableEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder)
	{
		if(searchCriteria.getOperator().equals(SearchOperator.IN))
		{
			predicatesList.add(criteriaBuilder.in(root.get(searchCriteria.getKey())).value(fieldValue));
		}
		else if(searchCriteria.getOperator().equals(SearchOperator.NOT_IN))
		{
			predicatesList.add(criteriaBuilder.not(root.get(searchCriteria.getKey())).in(fieldValue));
		}
		else if(searchCriteria.getOperator().equals(SearchOperator.GREATER_THAN))
		{
			//predicatesList.add(criteriaBuilder.gt(root.get(searchCriteria.getKey())).value(fieldValuesList));
		}
		else if(searchCriteria.getOperator().equals(SearchOperator.LESSER_THAN))
		{
			//predicatesList.add(criteriaBuilder.in(root.get(searchCriteria.getKey())).value(fieldValuesList));
		}
		else if(searchCriteria.getOperator().equals(SearchOperator.GREATER_THAN_EQUAL))
		{
			//predicatesList.add(criteriaBuilder.in(root.get(searchCriteria.getKey())).value(fieldValuesList));
		}
		else if(searchCriteria.getOperator().equals(SearchOperator.LESSER_THAN_EQUAL))
		{
			//predicatesList.add(criteriaBuilder.in(root.get(searchCriteria.getKey())).value(fieldValuesList));
		}
		else if(searchCriteria.getOperator().equals(SearchOperator.EQUALS_TO))
		{
			//predicatesList.add(criteriaBuilder.in(root.get(searchCriteria.getKey())).value(fieldValuesList));
		}
		else if(searchCriteria.getOperator().equals(SearchOperator.NOT_EQUAL))
		{
			//predicatesList.add(criteriaBuilder.in(root.get(searchCriteria.getKey())).value(fieldValuesList));
		}
		else if(searchCriteria.getOperator().equals(SearchOperator.CONTAINS))
		{
			//predicatesList.add(criteriaBuilder.in(root.get(searchCriteria.getKey())).value(fieldValuesList));
		}
		else if(searchCriteria.getOperator().equals(SearchOperator.STARTS_WITH))
		{
			//predicatesList.add(criteriaBuilder.in(root.get(searchCriteria.getKey())).value(fieldValuesList));
		}
	}

}
