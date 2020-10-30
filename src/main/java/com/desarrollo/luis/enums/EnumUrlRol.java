package com.desarrollo.luis.enums;

public enum EnumUrlRol {
	
	URL_NO_AUTENTICADO(EnumRol.ROLE_NO_AUTENTICADO,
			new EnumUrl[] {EnumUrl.LOGIN, EnumUrl.SIGNIN}),
	URL_ADMON(EnumRol.ROLE_ADMON,
			new EnumUrl[] {EnumUrl.PROFILE, EnumUrl.USUARIOS, EnumUrl.HOME, EnumUrl.CATEGORIA, EnumUrl.ROLES, EnumUrl.ENCUESTAS}),
	URL_USUARIO(EnumRol.ROLE_USUARIO,
			new EnumUrl[] {EnumUrl.HOME, EnumUrl.PROFILE})
	;
	
	private EnumUrl[] listaUrls;
	
	private EnumRol enumRol;
	
	private EnumUrlRol(EnumRol enumRol,EnumUrl[] listaUrls) {
		this.enumRol = enumRol;
		this.listaUrls = listaUrls;
	}

	public static EnumUrlRol consultarEnumUrlRolPorRol(String rol) {
		for(EnumUrlRol enumRolUrl: EnumUrlRol.values())
			if(rol.equals(enumRolUrl.getEnumRol().name()))
				return enumRolUrl;
		return null;
	}
	
	public EnumRol getEnumRol() {
		return enumRol;
	}

	public EnumUrl[] getListaUrls() {
		return listaUrls;
	}

}
