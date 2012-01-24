/* 
 *
 * SchemaCrawler
 * http://sourceforge.net/projects/schemacrawler
 * Copyright (c) 2000-2012, Sualeh Fatehi.
 *
 * This library is free software; you can redistribute it and/or modify it under the terms
 * of the GNU Lesser General Public License as published by the Free Software Foundation;
 * either version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this
 * library; if not, write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA 02111-1307, USA.
 *
 */
package schemacrawler.tools.traversal;


import schemacrawler.schema.ColumnDataType;
import schemacrawler.schema.Procedure;
import schemacrawler.schema.Table;
import schemacrawler.schemacrawler.SchemaCrawlerException;

public interface SchemaTraversalHandler
  extends TraversalHandler
{

  void handle(final ColumnDataType columnDataType)
    throws SchemaCrawlerException;

  /**
   * Provides information on the database schema.
   * 
   * @param procedure
   *        Procedure metadata.
   */
  void handle(final Procedure procedure)
    throws SchemaCrawlerException;

  /**
   * Provides information on the database schema.
   * 
   * @param table
   *        Table metadata.
   */
  void handle(final Table table)
    throws SchemaCrawlerException;

  void handleColumnDataTypesEnd()
    throws SchemaCrawlerException;

  void handleColumnDataTypesStart()
    throws SchemaCrawlerException;

  void handleProceduresEnd()
    throws SchemaCrawlerException;

  void handleProceduresStart()
    throws SchemaCrawlerException;

  void handleTablesEnd()
    throws SchemaCrawlerException;

  void handleTablesStart()
    throws SchemaCrawlerException;

}