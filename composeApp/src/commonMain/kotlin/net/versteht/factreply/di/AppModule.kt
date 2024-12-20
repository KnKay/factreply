package net.versteht.factreply.di

import org.koin.dsl.module

import net.versteht.factreply.database.*
import net.versteht.factreply.model.*
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind


val appModule = module {
    single { CategoryRepositoryJdbc() }
}
