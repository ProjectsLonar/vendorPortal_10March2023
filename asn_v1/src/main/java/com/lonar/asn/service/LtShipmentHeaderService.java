package com.lonar.asn.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lonar.asn.model.AsnApproval;
import com.lonar.asn.model.BusinessException;
import com.lonar.asn.model.LtPoShipment;
import com.lonar.asn.model.LtShipmentApprovalHistory;
import com.lonar.asn.model.LtShipmentHeaders;
import com.lonar.asn.model.LtShipmentLines;
import com.lonar.asn.model.ShipmenntSources;
import com.lonar.asn.model.Status;
import com.lonar.asn.model.SubmitAsn;

public interface LtShipmentHeaderService {
	List<String> getListOfStr()throws BusinessException;
	
	public ResponseEntity<Status> updateAsnHeader(LtShipmentHeaders ltShipmentHeaders) throws BusinessException;
	public ResponseEntity<Status> updateAsnLine(List<LtShipmentLines> ltShipmentLines) throws BusinessException;
	
	Long getAsnHeaderDataCount(LtShipmentHeaders input) throws BusinessException;
	List<LtShipmentHeaders> getAsnHeaderDataTableDetails(LtShipmentHeaders input) throws BusinessException;

	LtShipmentHeaders getByAsnHeaderId(Long id) throws BusinessException;

	List<LtShipmentLines> getAsnLinesByAsnHeaderId(Long id) throws BusinessException;

	Long getAsnHeaderDataCountByLocation(LtShipmentHeaders shipmentHeaders, Long locationId) throws BusinessException;

	List<LtShipmentHeaders> getAsnHeaderDataTableDetailsByLocation(LtShipmentHeaders shipmentHeaders, Long locationId) throws BusinessException;

	ResponseEntity<Status> deleteAsn(Long id) throws BusinessException;

	ResponseEntity<Status> submitAsn(SubmitAsn submitAsn) throws BusinessException;

	SubmitAsn getAsnStatusByAsnHeaderId(Long id) throws BusinessException;
	
	Long getCountpoShipmentDataTableByVendorId(LtPoShipment poShipment, Long vendorId) throws BusinessException;

	List<LtPoShipment> getPoShipmentDataTableByVendorId(LtPoShipment poShipment, Long vendorId) throws BusinessException;
	
	public ResponseEntity<Status> saveShipmentSource(List<ShipmenntSources> shipmenntSources) throws BusinessException;
	
	ResponseEntity<Status> deleteAsnLineAttachment(Long id) throws BusinessException;

	ResponseEntity<Status> createInvoiceFromAsn(LtShipmentHeaders ltShipmentHeaders) throws BusinessException;

	List<AsnApproval> getShipmentApprovalByShipmentId(Long shipmentId) throws BusinessException;

	Status updateShipmentStatusApproval(LtShipmentApprovalHistory approvalHistory) throws BusinessException;

	boolean checkStatusIsPending(Long shipmentId, Long approvalId) throws BusinessException;

	AsnApproval getShipmentApproval(Long shipmentId, Long apprId) throws BusinessException;

	List<LtShipmentApprovalHistory> getApprovalHistoryByShipmentId(Long shipmentHeaderId) throws BusinessException;

	ResponseEntity<Status> saveRemark(LtShipmentApprovalHistory ltShipmentApprovalHistory) throws BusinessException;

	

	Status getAsnApprovalByAsnHeaderId(Long asnHeaderId) throws BusinessException;
}
