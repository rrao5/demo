package com.nttdata.kata.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.nttdata.kata.domain.ApplicationPacket;
import com.nttdata.kata.domain.ApplicationStatusEnum;
import com.nttdata.kata.domain.Document;
import com.nttdata.kata.domain.DocumentStatusEnum;
import com.nttdata.kata.repository.ApplicationPacketRepository;

public class ApplicationPacketServiceImpl implements ApplicationPacketService {

	@Autowired
	ApplicationPacketRepository repository;

	@Override
	public ApplicationPacket submitApplicationPacket(
			ApplicationPacket applicationPacket) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApplicationPacket saveDraft(ApplicationPacket applicationPacket) {
		applicationPacket.setApplicationStatus(ApplicationStatusEnum.DRAFT);
		return repository.save(applicationPacket);

	}

	@Override
	public ApplicationStatusEnum checkStatus(Long applicationPacketId)
			throws Exception {
		ApplicationPacket packet = checkApplication(applicationPacketId);

		return packet.getApplicationStatus();

	}

	private ApplicationPacket checkApplication(Long applicationPacketId)
			throws Exception {
		if (applicationPacketId == null) {
			throw new Exception("Application id is null");
		}
		ApplicationPacket packet = repository.findOne(applicationPacketId);
		if (packet == null) {
			throw new Exception("Application is not found");
		}
		return packet;
	}

	@Override
	public Document addDocument(Long applicationPacketId, Document document)
			throws Exception {
		ApplicationPacket packet = checkApplication(applicationPacketId);
		document.setDocumentStatus(DocumentStatusEnum.SUBMITTED);
		packet.getDocuments().add(document);
		repository.save(packet);
		return document;
	}

}
