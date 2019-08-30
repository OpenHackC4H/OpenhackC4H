# Swedish Migration Agency

## Asylum rights for children

*Originally Published for OpenHack@Gothenburg2017*

### Hackathon projects addressing challenge
* Shotgun Sorters - [OpenHack 2017 in Gothenburg](https://github.com/OpenHackC4H/2017-Gothenburg-ShotgunSorters)
* http404 - [OpenHack 2017 in Gothenburg](https://github.com/OpenHackC4H/2017-Gothenburg-http404-db-api-admin)

### Author
Sofia Sjöö, <br>
Swedish Migration Agency (Migrationsverket),<br>
https://www.migrationsverket.se/

### Brief description
Swedish Migration Agency is the Swedish authority that considers applications from children and adults who want to take up permanent residence in Sweden. In this project, we want to help children understand the different steps within the migration process. We want help children understand with a “What happens next...” concept where we upload an image and a sound file to a web for each step in a process. We should be able to edit the process by deleting steps or change the order of the steps.

### Background
The ombudsman for children in Sweden have since 2015 interviewed to 600 children within the asylum process. They found that children who have been through the asylum process does not know what “asylum” is or when they went to an asylum investigation compared to other meeting they had with SMA.

More than 50 percent of all children who have a case open at SMA are accompanying adults who want to work here, are in a relationship with someone living here etc. There are no information at all aimed towards children outside of the asylum process. SMA rarely meet with these children as part of handling their parent’s cases and there are no information aimed at children outside of the asylum process.

### Challenge
We need to visualize an process with several steps. The process steps changes from time to time so we need to be able to edit the process steps.

We need to work with images and sounds.

We need to engage children and do so by using an ”What ́s next...”-concept

The solution could be:
* An admin web (bootstrap+node.js-server app+sql database) that provide an interface for uploading an image (1080x1920, 72 dpi) and sound file (mp4) for each step and allows deleting or changing order of the steps.
* An mobile web and/or an app for Android 5.0 and later and iOS 10 or later that provides a way to listen to the sound for each image, peek at the next upcoming image and to go back and forth between the different steps / images.

### Goals
The child is an expert of its own situation. Through this project we want to give children better tools to use their expertise within the migration process.

### End-user
The target group for this project are children who are currently in Sweden. The age group we are aiming at are children at the age of 11
