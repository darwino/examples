package com.darwino.domino.exampleplugin;

import com.darwino.domino.jstore.converters.DocumentConverterEvents;
import com.darwino.domino.jstore.converters.DocumentConverter.JsonHolder;
import com.darwino.domino.jstore.converters.ext.DocumentConverterPlugin;
import com.darwino.domino.napi.wrap.NSFNote;
import com.darwino.jsonstore.replication.impl.ReplicationSourceDocument;
import com.darwino.jsonstore.replication.impl.SkipDocumentException;

import lotus.domino.Document;

public class ExampleConverterPlugin extends DocumentConverterPlugin {
	/**
	 * The programmatic name of the plugin, currently {@value}
	 */
	public static final String NAME = "exampleConverterPlugin"; //$NON-NLS-1$

	@Override
	public String getName() {
		return NAME;
	}
	
	@Override
	public DocumentConverterEvents getEvents() {
		return new DocumentConverterEvents() {
			/*
			 * This hook allows for modifying a note before it is passed to the
			 * conversion routines. Changes here are not saved to the NSF unless
			 * explicitly done so in your code.
			 */
			@Override
			public boolean preConvertDominoToDarwino(NSFNote note) throws Exception {
				
				if(false) {
					// To programmatically skip a document during replication
					throw new SkipDocumentException(null);
				}
				
				return super.preConvertDominoToDarwino(note);
			}
			
			/*
			 * This hook allows for modifying a converted document immediately before
			 * it is sent to the Darwino database.
			 */
			@Override
			public boolean postConvertDominoToDarwino(JsonHolder jsonHolder) throws Exception {
				if(false) {
					// Retrieve the body field, which will have been converted to HTML
					//  if it was Notes rich text originally
					String body = jsonHolder.getJsonObject().getAsString("body");
					
				}
				
				return super.postConvertDominoToDarwino(jsonHolder);
			}
			
			/*
			 * This hook allows for modifying an incoming document from Darwino before
			 * it is converted to a NSF note format.
			 */
			@Override
			public boolean preConvertDarwinoToDomino(ReplicationSourceDocument jsonDocument) throws Exception {
				return super.preConvertDarwinoToDomino(jsonDocument);
			}
			
			/*
			 * This hook allows for modifying a document immediately before it is saved
			 * back into the NSF after arriving from Darwino
			 */
			@Override
			public boolean postConvertDarwinoToDomino(Document doc) throws Exception {
				return super.postConvertDarwinoToDomino(doc);
			}
		};
	}

}
