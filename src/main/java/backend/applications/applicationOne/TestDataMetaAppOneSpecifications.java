package backend.applications.applicationOne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import backend.applications.SearchCriteria;
import backend.applications.SearchCriteria.SearchOperator;

public class TestDataMetaAppOneSpecifications implements Specification<TestDataMetaAppOneEntity>
{

	private static final long serialVersionUID = 1L;
	public List<SearchCriteria> testDataMetaSearchCriteriaList;
	
	public TestDataMetaAppOneSpecifications()
	{
		testDataMetaSearchCriteriaList=new ArrayList<SearchCriteria>();
	}
	
	public void addNewTestDataMetaSearchCriteria(SearchCriteria newSearchCriteria)
	{
		testDataMetaSearchCriteriaList.add(newSearchCriteria);
	}
	
	@Override
	public Predicate toPredicate(Root<TestDataMetaAppOneEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder)
	{
		List<Predicate> predicatesList = new ArrayList<Predicate>();
		
		for (SearchCriteria searchCriteria : testDataMetaSearchCriteriaList)
		{
			String[] fieldValues=searchCriteria.getStringList();
			
			List<Integer> fieldNumberValuesList=searchCriteria.getNumberList();
			
			
			long number=searchCriteria.getNumber();
			
			if(number!=0)
				
			{
				if(searchCriteria.getOperator().equals(SearchOperator.IN))
				{
					predicatesList.add(criteriaBuilder.in(root.get(searchCriteria.getKey())).value(number));
				}
				else if(searchCriteria.getOperator().equals(SearchOperator.NOT_IN))
				{
					predicatesList.add(criteriaBuilder.not(root.get(searchCriteria.getKey())).in(number));
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
					predicatesList.add(criteriaBuilder.equal(root.get(searchCriteria.getKey()), searchCriteria.getText()));
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
			else if(fieldValues!=null && fieldValues.length>0)
			{
				List<String> fieldValuesList=Arrays.asList(fieldValues);
				
					//System.out.println("Text Values:"+fieldValue);
					System.out.println("searchCriteria:"+searchCriteria);
					
					if(searchCriteria.getOperator().equals(SearchOperator.IN))
					{
//						In<String> inClause = criteriaBuilder.in(root.get(searchCriteria.getKey()));
//						
//						for(String fieldValue:fieldValuesList)
//						{
//							inClause.value(fieldValue);
//						}
						predicatesList.add(criteriaBuilder.in(root.get(searchCriteria.getKey())).value(fieldValuesList));
					}
					else if(searchCriteria.getOperator().equals(SearchOperator.NOT_IN))
					{
						predicatesList.add(criteriaBuilder.not(root.get(searchCriteria.getKey())).in(fieldValuesList));
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
			else if(fieldNumberValuesList!=null && fieldNumberValuesList.size()>0)
			{					
					if(searchCriteria.getOperator().equals(SearchOperator.IN))
					{
						predicatesList.add(criteriaBuilder.in(root.get(searchCriteria.getKey())).value(fieldNumberValuesList));
					}
					else if(searchCriteria.getOperator().equals(SearchOperator.NOT_IN))
					{
						predicatesList.add(criteriaBuilder.not(root.get(searchCriteria.getKey())).in(fieldNumberValuesList));
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
			else if(searchCriteria.getDateFrom()!=null && searchCriteria.getDateTo()!=null)
			{
				System.out.println("Dates:"+searchCriteria.getKey()+" From "+searchCriteria.getDateFrom()+" to "+searchCriteria.getDateTo());

				if(searchCriteria.getOperator().equals(SearchOperator.BETWEEN_DATES))
				{			
					predicatesList.add(criteriaBuilder.between(root.get(searchCriteria.getKey()),searchCriteria.getDateFrom(), searchCriteria.getDateTo()));
				}
			}
		}
		
		return criteriaBuilder.and(predicatesList.toArray(new Predicate[predicatesList.size()]));
	}
	
	
		
		
		
	
	
	public List<Predicate> conditions(List<Predicate> predicatesList,SearchCriteria searchCriteria, String fieldValue, Root<TestDataMetaAppOneEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder)
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
		
		return predicatesList;
	}
	
	public List<Predicate> conditionsNumber(List<Predicate> predicatesList,SearchCriteria searchCriteria, long fieldValue, Root<TestDataMetaAppOneEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder)
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
		
		return predicatesList;
	}

}
