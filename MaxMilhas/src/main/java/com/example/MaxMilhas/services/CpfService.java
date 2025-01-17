package com.example.MaxMilhas.services;

import br.com.caelum.stella.format.CPFFormatter;
import com.example.MaxMilhas.domain.CpfDTO;
import com.example.MaxMilhas.exception.ExistsCpfException;
import com.example.MaxMilhas.exception.InvalidCpfException;
import com.example.MaxMilhas.exception.NotFoundCpfException;
import com.example.MaxMilhas.repository.CpfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;

import java.util.List;

@Service
public class CpfService {
    @Autowired
    private CpfRepository cpfRepository;
    private static final CPFValidator validator = new CPFValidator();

    public CpfService(CpfRepository cpfRepository) {
        this.cpfRepository = cpfRepository;
    }

    public CpfDTO add(CpfDTO cpf) {
        String formattedCpf = ValidatorCpf(cpf.getCpf());
        if (exists(formattedCpf)) {
            throw new ExistsCpfException("ExistsCpfException");
        }
        CpfDTO cpfEntity = new CpfDTO(formattedCpf);
        cpfRepository.save(cpfEntity);
        return cpfEntity;
    }

    public void deleteCpf(CpfDTO cpf) {
        CpfDTO cpfEntity = cpfRepository.findById(cpf.getId()).orElseThrow(
                () -> new NotFoundCpfException("NotFoundCpfException"));
        cpfRepository.delete(cpfEntity);
    }

    public CpfDTO findByCpf(String cpf) {
        String formattedCpf = ValidatorCpf(cpf);
        return cpfRepository.findByCpf(formattedCpf)
                .orElseThrow(() -> new NotFoundCpfException("NotFoundCpfException"));
    }

    public List<CpfDTO> findAllCPFs() {
        return cpfRepository.findAll();
    }

    public boolean exists(String cpf) {
        return cpfRepository.findByCpf(cpf).isPresent();
    }

    public String ValidatorCpf(String cpf) {
        try {
            CPFFormatter formatter = new CPFFormatter();
            String unformattedCpf = formatter.unformat(cpf);

            validator.assertValid(unformattedCpf);
            return formatter.format(unformattedCpf);

        } catch (InvalidStateException e) {
            throw new InvalidCpfException("InvalidCpfException");
        }
    }
}
