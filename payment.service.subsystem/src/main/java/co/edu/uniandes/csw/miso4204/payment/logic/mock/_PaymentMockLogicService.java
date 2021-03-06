/* ========================================================================
 * Copyright 2014 miso4204
 *
 * Licensed under the MIT, The MIT License (MIT)
 * Copyright (c) 2014 miso4204

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 * ========================================================================


Source generated by CrudMaker version 1.0.0.qualifier

*/

package co.edu.uniandes.csw.miso4204.payment.logic.mock;
import java.util.ArrayList;
import java.util.List;

import co.edu.uniandes.csw.miso4204.payment.logic.dto.PaymentDTO;
import co.edu.uniandes.csw.miso4204.payment.logic.dto.PaymentPageDTO;
import co.edu.uniandes.csw.miso4204.payment.logic.api._IPaymentLogicService;

public abstract class _PaymentMockLogicService implements _IPaymentLogicService {

	private Long id= new Long(1);
	protected List<PaymentDTO> data=new ArrayList<PaymentDTO>();

	public PaymentDTO createPayment(PaymentDTO payment){
		id++;
		payment.setId(id);
		data.add(payment);
		return payment;
    }
    
    public List<PaymentDTO> getPayments(){
		return data; 
	}

	public PaymentPageDTO getPayments(Integer page, Integer maxRecords){
		PaymentPageDTO response = new PaymentPageDTO();
		response.setTotalRecords(Long.parseLong(data.size()+""));
		response.setRecords(data);
		return response;
	}

	public PaymentDTO getPayment(Long id){
		for(PaymentDTO data1:data){
			if(data1.getId().equals(id)){
				return data1;
			}
		}
		return null;
	}

	public void deletePayment(Long id){
	    PaymentDTO delete=null;
		for(PaymentDTO data1:data){
			if(data1.getId().equals(id)){
				delete=data1;
			}
		}
		if(delete!=null){
			data.remove(delete);
		} 
	}

	public void updatePayment(PaymentDTO payment){
	    PaymentDTO delete=null;
		for(PaymentDTO data1:data){
			if(data1.getId().equals(payment.getId())){
				delete=data1;
			}
		}
		if(delete!=null){
			data.remove(delete);
			data.add(payment);
		} 
	}	
}