package com.nttdata.kata.service;

import com.nttdata.kata.domain.ApplicationPacket;
import com.nttdata.kata.domain.ApplicationStatusEnum;
import com.nttdata.kata.domain.Document;

public interface ApplicationPacketService {
	
	public ApplicationPacket submitApplicationPacket(ApplicationPacket applicationPacket)  throws Exception;
	public ApplicationPacket saveDraft(ApplicationPacket applicationPacket);
	public ApplicationStatusEnum checkStatus(Long applicationPacketId)  throws Exception;
	public Document addDocument(Long applicationPacketId, Document document) throws Exception;	

}
