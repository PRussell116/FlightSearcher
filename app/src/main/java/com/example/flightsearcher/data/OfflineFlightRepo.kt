package com.example.flightsearcher.data

import kotlinx.coroutines.flow.Flow

class OfflineFlightRepo(private val flightDao:AirportDAO): FlightRepo {
    override fun getAllAirportsStream(): Flow<List<FlightEntitiy>> = flightDao.getAllAirports()
    override fun getSearchTerm(term: String): Flow<List<FlightEntitiy>> = flightDao.getSearchTerm(term)
    override fun getWhereNotLike(id: Int): Flow<List<FlightEntitiy>> = flightDao.getWherenotLikeName(id)

    override fun getFaveStream(id: Int): Flow<FaveEntity> {
        TODO("Not yet implemented")
    }

    override fun getFlightStream(id: Int): Flow<FlightEntitiy?> {
        TODO("Not yet implemented")
    }


    override suspend fun insertFave(faveEntity: FaveEntity) = flightDao.insert(faveEntity)


    override suspend fun deleteFave(faveEntity: FaveEntity) =flightDao.delete(faveEntity)



}