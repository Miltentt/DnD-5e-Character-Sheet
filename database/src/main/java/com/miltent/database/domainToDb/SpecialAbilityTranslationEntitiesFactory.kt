package com.miltent.database.domainToDb

import com.miltent.database.entities.specialAbility.SpecialAbilityEntity
import com.miltent.database.entities.specialAbility.SpecialAbilityTranslationEntity
import com.miltent.domain.model.LanguageSuffix
import java.util.UUID

class SpecialAbilityTranslationEntitiesFactory {
    companion object{
        fun createSpecialAbilityTranslationEntity(
            language: String,
            specialAbilityId: String,
            name: String,
            description: String
        ): SpecialAbilityTranslationEntity {
            val id = UUID.randomUUID().toString()
            return SpecialAbilityTranslationEntity(
                id = id,
                specialAbilityId = specialAbilityId,
                languageSuffix = language,
                name = name,
                description = description
            )
        }
        fun createSpecialAbilityTranslationEntities(): List<SpecialAbilityTranslationEntity> {
            val enFightingStyleNamesWithDescriptions = listOf<Pair<String,String>>(
                Pair("Archery","You gain a +2 bonus to attack rolls you make with ranged weapons."),
                Pair("Blind Fighting","You have blindsight with a range of 10 feet. Within that range," +
                        " you can effectively see anything that isn't behind total cover," +
                        " even if you're blinded or in darkness." +
                        " Moreover, you can see an invisible creature within that range," +
                        " unless the creature successfully hides from you."),
                Pair("Defense","While you are wearing armor, you gain a +1 bonus to AC."),
                Pair("Dueling","When you are wielding a melee weapon in one hand and no other weapons," +
                        " you gain a +2 bonus to damage rolls with that weapon."),
                Pair("Great Weapon Fighting",
                    "When you roll a 1 or 2 on a damage die for an attack you make with a melee weapon" +
                        " that you are wielding with two hands, you can reroll the die and must use the new roll," +
                        " even if the new roll is a 1 or a 2." +
                        " The weapon must have the two-handed or versatile property for you to gain this benefit."),
                Pair("Interception","When a creature you can see hits a target," +
                        " other than you, within 5 feet of you with an attack," +
                        " you can use your reaction to reduce the damage the target takes" +
                        " by 1d10 + your proficiency bonus (to a minimum of 0 damage)." +
                        " You must be wielding a shield or a simple or martial weapon to use this reaction."),
                Pair("Protection",
                    "When a creature you can see attacks a target other than you that is within 5 feet of you," +
                        " you can use your reaction to impose disadvantage on the attack roll. You must be wielding a shield."),
                Pair("Superior Technique",
                    "You learn one maneuver of your choice from among those available to the Battle Master archetype." +
                        " If a maneuver you use requires your target to make a saving throw to resist the maneuver's effects," +
                        " the saving throw DC equals 8 + your proficiency bonus + your Strength or Dexterity modifier (your choice.)\n" +
                        "You gain one superiority die, which is a d6" +
                            " (this die is added to any superiority dice you have from another source)." +
                        " This die is used to fuel your maneuvers. A superiority die is expended when you use it." +
                        " You regain your expended superiority dice when you finish a short or long rest."),
                Pair("Thrown Weapon Fighting","You can draw a weapon that has the thrown property" +
                        " as part of the attack you make with the weapon.\n" +
                        "In addition, when you hit with a ranged attack using a thrown weapon," +
                        " you gain a +2 bonus to the damage roll."),
                Pair("Two-Weapon Fighting","YWhen you engage in two-weapon fighting," +
                        " you can add your ability modifier to the damage of the second attack.\n"),
                Pair("Unarmed Fighting",
                    "Your unarmed strikes can deal bludgeoning damage equal to 1d6 + your Strength modifier on a hit." +
                        " If you aren't wielding any weapons or a shield when you make the attack roll, the d6 becomes a d8.\n" +
                        "At the start of each of your turns, you can deal 1d4 bludgeoning damage to one creature grappled by you."),
            )
            val plFightingStyleNamesWithDescriptions = listOf<Pair<String,String>>(Pair("Łucznictwo","+2 do rzutów ataku wykonywanych bronią dystansową."),
                Pair("Obrona","+1 do CA, gdy masz założony pancerz."),
                Pair("Pojedynkowanie","+2 do obrażeń podczas walki jednoręczną bronią bez trzymania innej broni w drugiej ręce."),
                Pair("Walka Wielką Bronią","Możesz przerzucać wyniki 1 i 2 na kościach obrażeń, używając broni dwuręcznej lub wymagającej dwóch rąk."),
                Pair("Ochrona","Używając reakcji i mając tarczę, dajesz disadvantage na atak wymierzony w sojusznika w zasięgu 1,5 m."),
                Pair("Walka Dwoma Broniami","Dodajesz modyfikator cechy do obrażeń z ataku dodatkowego drugą bronią."),
                Pair("Walka na Oślep","Zyskujesz ślepowidzenie na 3 metry (10 ft)."),
                Pair("Przechwycenie","Reakcją zmniejszasz obrażenia otrzymane przez sojusznika o 1k10 + twój modyfikator biegłości."),
                Pair("Walka Bronią Miotaną","Możesz dobywać broń miotaną jako część ataku i zadajesz +2 obrażeń taką bronią."),
                Pair("Technika Mistrzowska","Zyskujesz 1 manewr oraz 1 kość wyczynu (1k6) działającą jak u Mistrza Bitewnego."),
                Pair("Walka Bez Broni","Twoje nieuzbrojone ataki zadają 1k6 lub 1k8 obrażeń, a trzymanemu przeciwnikowi zadasz 1k4 obrażeń na początku tury."),)
            val enFightingStylesIdToNameToDescription: List<Triple<String, String, String>> =
                SpecialAbilityEntityFactory
                    .fightingStyleSpecialAbilityEntities
                    .mapIndexed { index, it -> Triple(
                        it.id,
                        enFightingStyleNamesWithDescriptions[index].first,
                        enFightingStyleNamesWithDescriptions[index].second
                        )
                    }
            val plFightingStylesIdToNameToDescription : List<Triple<String, String, String>> =
                SpecialAbilityEntityFactory
                    .fightingStyleSpecialAbilityEntities
                    .mapIndexed { index, it -> Triple(
                        it.id,
                        plFightingStyleNamesWithDescriptions[index].first,
                        plFightingStyleNamesWithDescriptions[index].second
                    )
                    }

            val languageToFightingStylesMap = mapOf<LanguageSuffix, List<Triple<String,String,String>>>(
                LanguageSuffix.PL to plFightingStylesIdToNameToDescription,
                LanguageSuffix.EN to enFightingStylesIdToNameToDescription
            )
            val listOfSpecialAbilityTranslations = languageToFightingStylesMap.map {
                (language, fightingStyles) ->
                fightingStyles.map {
                    (specialAbilityId,fightingStyleName, fightingStyleDescription) ->
                    createSpecialAbilityTranslationEntity(
                        language = language.value,
                        specialAbilityId = specialAbilityId,
                        name = fightingStyleName,
                        description = fightingStyleDescription
                    )
                }
            }.flatten()
            return listOfSpecialAbilityTranslations
        }
    }
}