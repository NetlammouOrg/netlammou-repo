package tn.esprit.pidev.presentation.mbeans;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import tn.esprit.pidev.util.ActionServiceRemote;


@ManagedBean
@ViewScoped
public class StatBean {
	
	
		public Map<String, Long> m;
		@EJB
		ActionServiceRemote service;
		public Map<String, Long> getM() {
			return m;
		}

		public void setM(Map<String, Long> m) {
			this.m = m;
		}
		
		public void init(){
			m = service.getActionByTypes();
		}
		
		public String getPieData(){
			Set<Entry<String, Long>> set = m.entrySet();
			String data="";
			Iterator<Entry<String, Long>> it = set.iterator();
			while (it.hasNext()){
				
				Entry<String, Long> e = it.next();
				data+="{ label :'"+e.getKey()+"', value:"+e.getValue()+"}";
				if (it.hasNext()){
					data+=",";
				}
			}
			return data;
		}
		
	}


