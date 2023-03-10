package com.lonar.asn.dao;

import java.util.Date;
import java.util.List;

import com.lonar.asn.model.AsnApproval;
import com.lonar.asn.model.BusinessException;
import com.lonar.asn.model.LtMastAttachmentType;
import com.lonar.asn.model.LtPoShipment;
import com.lonar.asn.model.LtShipmentApprovalHistory;
import com.lonar.asn.model.LtShipmentHeaders;
import com.lonar.asn.model.LtShipmentLines;
import com.lonar.asn.model.ProcedureCall;
import com.lonar.asn.model.Status;
import com.lonar.asn.model.SubmitAsn;

public interface LtShipmentHeaderDao {

	List<String> getListOfStr()throws BusinessException;
	
	Long getAsnHeaderDataCount(LtShipmentHeaders input) throws BusinessException;
	List<LtShipmentHeaders> getAsnHeaderDataTableDetails(LtShipmentHeaders input) throws BusinessException;

	LtShipmentHeaders getByAsnHeaderId(Long id) throws BusinessException;

	List<LtShipmentLines> getAsnLinesByAsnHeaderId(Long id) throws BusinessException;

	boolean updateLines(LtShipmentLines ltShipmentLines) throws BusinessException;

	Long getAsnHeaderDataCountByLocation(LtShipmentHeaders shipmentHeaders, Long locationId) throws BusinessException;

	List<LtShipmentHeaders> getAsnHeaderDataTableDetailsByLocation(LtShipmentHeaders input, Long locationId) throws BusinessException;

	boolean submitAsn(SubmitAsn submitAsn) throws BusinessException;

	SubmitAsn getAsnStatusByAsnHeaderId(Long id) throws BusinessException;
	
	Long getCountpoShipmentDataTableByVendorId(LtPoShipment poShipment, Long vendorId) throws BusinessException;

	List<LtPoShipment> getPoShipmentDataTableByVendorId(LtPoShipment poShipment, Long vendorId) throws BusinessException;
	
	Long getShipmentSourceIds() throws BusinessException;
	
	//public ResponseEntity<Status> saveShipmentSource(List<Integer> shipmentIds) throws BusinessException;
	
	ProcedureCall saveAsnHeaderAndLineData(Long sourceId) throws BusinessException;
	
	public boolean deleteAsnLineAttachment(Long id) throws BusinessException;

	ProcedureCall createInvoiceFromAsn(Long shipmentHeaderId, Long userId) throws BusinessException;

	boolean updatePoShipmentLines(LtShipmentLines ltShipmentLinesObj) throws BusinessException;

	boolean updateRecivedQuantity(LtShipmentLines ltShipmentLinesObj) throws BusinessException;

	List<LtShipmentHeaders> getInprocessAsnList(String asnInprogress) throws BusinessException;

	AsnApproval getApprovalLevel(Long shipmentHeaderId) throws BusinessException;

	List<AsnApproval> getApprovalList(Long shipmentHeaderId, String currentApprovalLevel) throws BusinessException;

	String getNextApprovalLevel(Long shipmentHeaderId, String currentApprovalLavel) throws BusinessException;

	boolean upDateStatus(Long shipmentHeaderId, String pending, String currentApprovalLavel) throws BusinessException;

	void updateCurrentApprovalLevel(Long shipmentHeaderId, String currentApprovalLavel) throws BusinessException;

	List<AsnApproval> getShipmentApprovalByShipmentId(Long shipmentHeaderId) throws BusinessException;

	boolean updateStatusApproval(LtShipmentApprovalHistory approvalHistory) throws BusinessException;

	String getCurrLevelByShipmentApprovalId(Long shipmentApprovalId) throws BusinessException;

	boolean submitForApproval(Date submissionDate, Long shipmentHeaderId, String status, Date approvedDate,
			Long lastUpdateLogin) throws BusinessException;

	boolean checkStatusIsPending(Long shipmentId, Long approvalId)  throws BusinessException;

	AsnApproval getShipmentApproval(Long shipmentId, Long apprId) throws BusinessException;

	List<LtShipmentApprovalHistory> getApprovalHistoryByShipmentId(Long shipmentHeaderId) throws BusinessException;

	boolean saveRemark(LtShipmentApprovalHistory ltShipmentApprovalHistory)  throws BusinessException;

	Status getAsnApprovalByAsnHeaderId(Long asnHeaderId) throws BusinessException;

	List<LtMastAttachmentType> getAsnAttachmentList(LtShipmentHeaders ltShipmentHeaders)  throws BusinessException;

	ProcedureCall asnValidationPkgCall(Long shipmentHeaderId) throws BusinessException;

	ProcedureCall asnDeletePkgCall(Long id) throws BusinessException;

	LtShipmentLines getQuantityByPoHeaderId(Long poHeaderId) throws BusinessException;

	boolean loadInvoiceApprovers(Long shipmentHeaderId) throws BusinessException;
}
