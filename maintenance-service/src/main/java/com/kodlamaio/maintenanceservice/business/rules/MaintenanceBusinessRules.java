package com.kodlamaio.maintenanceservice.business.rules;

import com.kodlamaio.commonpackage.utils.exceptions.BusinessException;
import com.kodlamaio.maintenanceservice.api.clients.CarClient;
import com.kodlamaio.maintenanceservice.repository.MaintenanceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class MaintenanceBusinessRules {
    private final MaintenanceRepository repository;
    private final CarClient client;

    public void ensureCarIsAvailable(UUID carId)
    {
        var response = client.checkIfCarAvailable(carId);
        if(!response.isSuccess())
        {
            throw new BusinessException(response.getMessage());
        }
    }

    public void checkIfMaintenanceExists(UUID id) {
        if (!repository.existsById(id)) {
            throw new BusinessException("MAINTENANCE_NOT_EXISTS");
        }
    }

    public void checkIfCarUnderMaintenance(UUID carId) {
        if (repository.existsByCarIdAndIsCompletedIsFalse(carId)) {
            throw new BusinessException("CAR_ALREADY_UNDER_MAINTENANCE");
        }
    }

}
