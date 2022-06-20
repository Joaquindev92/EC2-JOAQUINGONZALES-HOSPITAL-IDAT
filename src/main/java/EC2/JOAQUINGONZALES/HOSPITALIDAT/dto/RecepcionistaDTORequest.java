package EC2.JOAQUINGONZALES.HOSPITALIDAT.dto;

public class RecepcionistaDTORequest {
	
	private Integer idRecepcionistaDTO;
	private String nombreDTO;
	private Integer celularDTO;
	
	public RecepcionistaDTORequest() {
		super();
	}

	public Integer getIdRecepcionistaDTO() {
		return idRecepcionistaDTO;
	}

	public void setIdRecepcionistaDTO(Integer idRecepcionistaDTO) {
		this.idRecepcionistaDTO = idRecepcionistaDTO;
	}

	public String getNombreDTO() {
		return nombreDTO;
	}

	public void setNombreDTO(String nombreDTO) {
		this.nombreDTO = nombreDTO;
	}

	public Integer getCelularDTO() {
		return celularDTO;
	}

	public void setCelularDTO(Integer celularDTO) {
		this.celularDTO = celularDTO;
	}
	
	
	

}
