package br.es.senac.trabalho_referencia.api;

public interface OnEventListener<T> {
    public void onSuccess(T object);
    public void onFailure(Exception e);
}