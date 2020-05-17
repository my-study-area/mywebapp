package br.mywebapp.converter;

import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.mywebapp.model.Categoria;


@FacesConverter(value = "categoriaConverter")
public class CategoriaConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || !value.matches("\\d+")) {
            return null;
        }
        return this.getAttributeForm(component).get(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null && !value.equals("")) {
            Categoria categoria = (Categoria) value;
            if (categoria.getId() != null) {
                this.addAtribute(component, categoria);
                return categoria.getId().toString();
            }
        }
        return null;
    }

    private Map<String, Object> getAttributeForm(UIComponent component) {
        return component.getAttributes();
    }

    private void addAtribute(UIComponent component, Categoria categoria) {
        this.getAttributeForm(component).put(categoria.getId().toString(), categoria);
    }
}
